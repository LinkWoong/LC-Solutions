package Leetcode;

import java.util.Arrays;

/*
    Given a string, you need to reverse the order of characters in each word within a sentence
    while still preserving whitespace and initial word order.

    Example 1:

    Input: "Let's take LeetCode contest"
    Output: "s'teL ekat edoCteeL tsetnoc"
    Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class Easy_ReverseString_557 {
    public static void main(String[] args){
        String s = "Let's take LeetCode contest";
        String result = reverseWords(s);
        System.out.println(result);
    }

    // Runtime: 22 ms, faster than 29.20% of Java online submissions
    public static String reverseWords(String s){
        StringBuilder res = new StringBuilder();
        for(String str: s.split(" ")){
            char[] result = new char[str.length()];
            for(int i = str.length() - 1; i >= 0; i--){
                result[str.length() - i - 1] = str.charAt(i);
            }
            res.append(new String(result) + " ");
        }

        return res.toString().replaceAll("\\s+$", "");
    }


}
