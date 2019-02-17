package Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
    Example 1:

    Given nums = [1,1,2],

    Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

    It doesn't matter what you leave beyond the returned length.
    Example 2:

    Given nums = [0,0,1,1,1,2,2,3,3,4],

    Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 */
public class Easy_RemoveDupsFromArray_26 {
    // 思路：目的是在原有数组上修改，使得前x个元素为unique
    // 只需要统计重复元素的个数，再在每次遍历元素时将目前元素nums[i]赋值给nums[i-dups]
    // 即向前移动dups个index
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        int dups = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1])
                dups++;
            nums[i - dups] = nums[i];
        }
        return nums.length - dups;
    }
}
