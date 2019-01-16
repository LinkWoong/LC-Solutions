package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
    You have an array of logs.  Each log is a space delimited string of words.

    For each log, the first word in each log is an alphanumeric identifier.  Then, either:

    Each word after the identifier will consist only of lowercase letters, or;
    Each word after the identifier will consist only of digits.
    We will call these two varieties of logs letter-logs and digit-logs.
    It is guaranteed that each log has at least one word after its identifier.

    Reorder the logs so that all of the letter-logs come before any digit-log.
    The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
    The digit-logs should be put in their original order.

    Return the final order of the logs.

    Example 1:

    Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
    Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]


    Note:

    0 <= logs.length <= 100
    3 <= logs[i].length <= 100
    logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */
public class Easy_RecordLogFiles_937 {

    // 思路：题目已经说明字母按照字典顺序，数字按照大小。所以可以利用自带的compareTo方法。
    // 首先把每个log按照identifier-log分到一个数组中，第一个元素是identifier，第二个是log。
    // 再检查log是letter-log还是digit-log，如果都是letter，就用compareTo方法来比较
    // 如果一个为digit另一个为letter，先返回letter-log再返回digit-log
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] split1 = s1.split("\\s+", 2);
                String[] split2 = s2.split("\\s+", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                if(!isDigit1 && !isDigit2){ // they are letter logs
                    int res = split1[1].compareTo(split2[1]);
                    if(res != 0){
                        return res;
                    }
                    return split1[0].compareTo(split2[0]);
                }
                return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
            }
        };
        Arrays.sort(logs, cmp);
        return logs;
    }
}
