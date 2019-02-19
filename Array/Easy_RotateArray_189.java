package Leetcode;

import java.util.Arrays;

/*
    Given an array, rotate the array to the right by k steps, where k is non-negative.

    Example 1:

    Input: [1,2,3,4,5,6,7] and k = 3
    Output: [5,6,7,1,2,3,4]

    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]

    Example 2:

    Input: [-1,-100,3,99] and k = 2
    Output: [3,99,-1,-100]

    Explanation:
    rotate 1 steps to the right: [99,-1,-100,3]
    rotate 2 steps to the right: [3,99,-1,-100]

    Note:

    Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
    Could you do it in-place with O(1) extra space?
 */
public class Easy_RotateArray_189 {
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate_v2(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    // 思路1：最直接的想法，将最后一个元素储存，再将整个数组整体shift right by 1
    // （重复k次）
    public static void rotate(int[] nums, int k) {
        for(int i = 0; i < k; i++){
            int last = nums[nums.length - 1];
            for(int j = nums.length - 2; j>= 0; j--)
                nums[j+1] = nums[j];
            nums[0] = last;
        }
    }

    // 思路2：先翻转整个数组，再翻转0:k-1，再翻转k:nums.length-1数组
    // 例：[1, 2, 3, 4, 5 ,6, 7] -> [7, 6, 5, 4, 3, 2, 1] -> [5, 6, 7, 4, 3, 2, 1] -> [5, 6, 7, 1, 2, 3, 4]
    public static void rotate_v2(int[] nums, int k){
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int l, int r){
        while(l < r){
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
    }
}
