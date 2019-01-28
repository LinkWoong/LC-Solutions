package Leetcode;

import java.util.Arrays;

/*
    Given a positive integer, return its corresponding column title as appear in an Excel sheet.

    For example:

        1 -> A
        2 -> B
        3 -> C
        ...
        26 -> Z
        27 -> AA
        28 -> AB
        ...
    Example 1:

    Input: 1
    Output: "A"
    Example 2:

    Input: 28
    Output: "AB"
    Example 3:

    Input: 701
    Output: "ZY"
 */
public class Easy_ExcelSheetColTitle_168 {
    // 思路：每次都在StringBuilder最前端插入'A' + n对26取余对应的字符即可
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0){
            n--;
            res.insert(0, (char)('A' + n % 26));
            n = n / 26;
        }

        return res.toString();
    }

}
