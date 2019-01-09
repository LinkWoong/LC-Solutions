package Leetcode;

import java.util.*;

/*
    We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)

    A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
    Return a list of all uncommon words.
    You may return the list in any order.

    Example 1:

    Input: A = "this apple is sweet", B = "this apple is sour"
    Output: ["sweet","sour"]

    Example 2:

    Input: A = "apple apple", B = "banana"
    Output: ["banana"]

    Note:
    0 <= A.length <= 200
    0 <= B.length <= 200
    A and B both contain only spaces and lowercase letters.
*/
public class Easy_UncommonWords_884 {
    public static void main(String[] args){
        String A = "apple apple";
        String B = "banana";
        String[] res = uncommonFromSentences(A, B);
        System.out.println(Arrays.toString(res));

    }
    // Runtime: 17 ms, faster than 8.10% of Java online submissions
    // 利用Hashtable计算每个str哈希值，再根据要求选出value=1并且不在对方哈希表的substr
    public static String[] uncommonFromSentences(String A, String B) {
        Hashtable<String, Integer> ht_A = new Hashtable<>();
        Hashtable<String, Integer> ht_B = new Hashtable<>();
        List<String> res = new ArrayList<>();

        helper(ht_A, A);
        helper(ht_B, B);

        for(String str: ht_A.keySet()){
            if(ht_A.get(str) == 1 && !ht_B.containsKey(str))
                res.add(str);
        }

        for(String str: ht_B.keySet()){
            if(ht_B.get(str) == 1 && !ht_A.containsKey(str))
                res.add(str);
        }

        String[] result = new String[res.size()];
        for(int i = 0; i < res.size(); i++)
            result[i] = res.get(i);
        return result;

    }

    private static void helper(Hashtable<String, Integer> table, String str){
        for(String substr: str.split("\\s+")){
            if(!table.containsKey(substr))
                table.put(substr, 1);
            else{
                Integer val = table.get(substr);
                if(val == null)
                    val = 1;
                val++;
                table.put(substr, val);
            }
        }
    }
}
