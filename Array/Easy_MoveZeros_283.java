package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given an array nums, write a function to move all 0's to the end of it
    while maintaining the relative order of the non-zero elements.

    Example:

    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]
    Note:

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.
*/
public class Easy_MoveZeros_283 {

    // 思路：先把non-zero和zero的个数记录下来，再把0append到新数组中去
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num != 0) {
                list.add(num);
            }
        }
        for(int i = 0; i < n; i++){
            if(i < list.size())
                nums[i] = list.get(i);
            else
                nums[i] = 0;
        }
    }
}
