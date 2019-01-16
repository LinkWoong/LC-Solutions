package Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
    Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place,
    and all letters reverse their positions.

    Example 1:

    Input: "ab-cd"
    Output: "dc-ba"

    Example 2:

    Input: "a-bC-dEf-ghIj"
    Output: "j-Ih-gfE-dCba"

    Example 3:

    Input: "Test1ng-Leet=code-Q!"
    Output: "Qedo1ct-eeLg=ntse-T!"
    Note:

    S.length <= 100
    33 <= S[i].ASCIIcode <= 122
    S doesn't contain \ or "
 */
public class Easy_ReverseOnlyLetters_917 {

    // 思路：之前想复杂了，用了regex来把字符和char分开再组合，有点麻烦。
    // 另一个解法：
    // 从str首部开始append每个char，再reverse。再遍历一遍reverse后的str，遇到是non-letter的字符就插入到reverse后str相应的位置

    public String reverseOnlyLetters(String str){
        StringBuilder res = new StringBuilder();
        for(char c: str.toCharArray()){
            if(Character.isLetter(c))
                res.append(c);
        }
        res.reverse();

        for(int i = 0; i < str.length(); i++){
            if(!Character.isLetter(str.charAt(i)))
                res.insert(i, str.charAt(i));
        }

        return res.toString();
    }

    /*
    public String reverseOnlyLetters(String str) {
        String[] split = str.split("[$&+,:;=?@#|!()*.<>\\[\\]\\-0-9]");

        String symbol = str.replaceAll("[a-zA-Z]", "");
        Queue<Character> queue = new LinkedList<>();
        for(char c: symbol.toCharArray())
            queue.add(c);

        StringBuilder sb = new StringBuilder();
        String merge = new StringBuilder(String.join("", split)).reverse().toString();

        for(int i = split.length - 1; i >= 0; i--){
            sb.append(new StringBuilder(split[i]).reverse().toString());
            if(queue.size() != 0){
                sb.append(queue.remove());
            }
        }

        for(String temp: split){
            for(int i = 0; i < temp.length() - 1; i++){
                sb.append(merge.charAt(i));
                merge = merge.substring(i+1, merge.length() - 1);
            }
            if(queue.size() != 0)
                sb.append(queue.remove());
        }
        return sb.toString();
    }
    */

}
