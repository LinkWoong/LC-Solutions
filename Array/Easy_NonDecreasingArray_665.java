package Leetcode;

import java.util.Arrays;

/*
    Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

    We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

    Example 1:
    Input: [4,2,3]
    Output: True
    Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
    Example 2:
    Input: [4,2,1]
    Output: False
    Explanation: You can't get a non-decreasing array by modify at most one element.
 */
public class Easy_NonDecreasingArray_665 {

    // 思路：重点在于替换开始下降的那个元素，例[4, 2, 3]中从4开始下降，那么就要替换4
    // 一种想法是把4替换成nums[i]，但是对于[2, 3, 3, 2, 4]来说，将3替换成2 which becomes[2, 3, 2, 2, 4] => false
    // 但结果是true，因为可以把[2, 3, 3, 2, 4]中的第二个2换成3，[2, 3, 3, 3, 4] => true
    // 所以替换时要考虑前两个元素而不是一个。如果nums[i-2] <= nums[i]说明上面提到的替换是可以进行的，就把前一个元素替换成nums[i]
    // 如果nums[i-2] > nums[i]，就像[4, 3, 1, 4] -> [2, 3, 1, 4]，就把nums[i]换成前一个元素nums[i-1] -> [2, 3, 3, 4]
    // 因为前一个元素经过之前的操作已经肯定比nums[i-2]要大。对于上面这个case，已经换过两次了所以为false
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for(int i = 1; i < nums.length && count <= 1; i++){
            if(nums[i-1] > nums[i]){
                count++;
                if(i-2 < 0 || nums[i-2] <= nums[i])
                    nums[i-1] = nums[i];
                else
                    nums[i] = nums[i-1];
            }
        }
        return count <= 1;
    }
}
