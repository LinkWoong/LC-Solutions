package Leetcode;
/*
    Given a sorted array and a target value, return the index if the target is found.
    If not, return the index where it would be if it were inserted in order.
    You may assume no duplicates in the array.

    Example 1:

    Input: [1,3,5,6], 5
    Output: 2
    Example 2:

    Input: [1,3,5,6], 2
    Output: 1
    Example 3:

    Input: [1,3,5,6], 7
    Output: 4
    Example 4:

    Input: [1,3,5,6], 0
    Output: 0
 */
public class Easy_SearchIndex_35 {
    // 思路：Binary search即可解决，注意left和right的update是mid+1和mid
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 0, right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            } else if(nums[mid] > target){
                right = mid;
            } else {
                return mid;
            }
        }
        return left;
    }
}
