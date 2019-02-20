package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
    The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
    You may assume the integer does not contain any leading zero, except the number 0 itself.

    Example 1:

    Input: [1,2,3]
    Output: [1,2,4]
    Explanation: The array represents the integer 123.

    Example 2:

    Input: [4,3,2,1]
    Output: [4,3,2,2]
    Explanation: The array represents the integer 4321.
 */
public class Easy_plusOne_66 {

    // 思路：从最后一位开始遍历，如果当前元素小于9直接+1返回；大于等于9就赋值为0
    // 如果把所有元素都访问了一遍，说明所有元素都>=9，需要开辟一块新的空间给数组（进位，nums.length变长了
    // 再令nums[0]=1然后返回
    public int[] plusOne(int[] digits){
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

}
