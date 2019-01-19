package Leetcode;

import java.util.Arrays;

/*
    Given an array nums of n integers where n > 1,  return an array output such that output[i]
    is equal to the product of all the elements of nums except nums[i].

    Example:

    Input:  [1,2,3,4]
    Output: [24,12,8,6]
    Note: Please solve it without division and in O(n).

    Follow up:
    Could you solve it with constant space complexity? (The output array does not count as extra space
    for the purpose of space complexity analysis.)

 */
public class Medium_ProductofArray_238 {
    // 思路：可以直接算总乘积，再遍历nums，分别除以num[i]即可。但题目说不允许用division，并且要o(n)，所以就不能两个for嵌套检索。
    // 2-pass来遍历两次nums，第一次利用right accumulator记录num从最末尾起往前一位的乘积；
    // 第二次利用left accumulator记录num从头起往后一位的乘积，再叠乘到res上
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 1, right = 1;

        for(int i = n - 1; i>= 0; i--){
            res[i] = right;
            right *= nums[i];
        }

        for(int i = 0; i < n; i++){
            res[i] *= left;
            left *= nums[i];
        }
        return res;
    }
}
