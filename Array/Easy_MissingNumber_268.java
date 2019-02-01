package Leetcode;
/*
    Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

    Example 1:

    Input: [3,0,1]
    Output: 2
    Example 2:

    Input: [9,6,4,2,3,5,7,0,1]
    Output: 8
    Note:
    Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
*/
public class Easy_MissingNumber_268 {
    // 思路：目的是找到range(min, max)中丢失的一位数字，假设必定存在，则可以计算每个nums[i]和其index的差值
    // 再累加起来，nums.length - sum就是丢失的数字
    public int missingNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++)
            res += nums[i] - i;
        return nums.length - res;
    }
}
