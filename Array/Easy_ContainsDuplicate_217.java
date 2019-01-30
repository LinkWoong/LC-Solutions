package Leetcode;

import java.util.HashSet;

/*
    Given an array of integers, find if the array contains any duplicates.
    Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

    Example 1:

    Input: [1,2,3,1]
    Output: true
    Example 2:

    Input: [1,2,3,4]
    Output: false
    Example 3:

    Input: [1,1,1,3,3,4,3,2,4,2]
    Output: true
 */
public class Easy_ContainsDuplicate_217 {
    // 思路：利用HashSet自带的HashCode方法，将每个元素计算一个哈希值放入set中，重复元素不会放入
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num: nums)
            hs.add(num);
        return nums.length != hs.size();
    }
}
