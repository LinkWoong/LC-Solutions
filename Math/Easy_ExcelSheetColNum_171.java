package Leetcode;

import java.util.Arrays;

/*
    Given a column title as appear in an Excel sheet, return its corresponding column number.
    For example:

        A -> 1
        B -> 2
        C -> 3
        ...
        Z -> 26
        AA -> 27
        AB -> 28
        ...
    Example 1:

    Input: "A"
    Output: 1
    Example 2:

    Input: "AB"
    Output: 28
    Example 3:

    Input: "ZY"
    Output: 701
 */
public class Easy_ExcelSheetColNum_171 {
    public int titleToNumber(String s) {
        String dict = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] map = new int[dict.length()];
        for(int i = 0; i < dict.length(); i++)
            map[dict.charAt(i) - 'A'] = i+1;

        int res = 0;
        int idx = 0;
        for(int i = 0; i < s.length(); i++){
            idx = s.length() - i - 1;
            if(idx != 0){
                res += Math.pow(26, idx) * map[s.charAt(i) - 'A'];
            }
            else
                res += map[s.charAt(i) - 'A'];
        }

        return res;
    }
}
