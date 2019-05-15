package Leetcode;
/*
    Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
    prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
    find the duplicate one.

    Example 1:

    Input: [1,3,4,2,2]
    Output: 2
    Example 2:

    Input: [3,1,3,4,2]
    Output: 3
    Note:

    You must not modify the array (assume the array is read only).
    You must use only constant, O(1) extra space.
    Your runtime complexity should be less than O(n2).
    There is only one duplicate number in the array, but it could be repeated more than once.

 */
public class Medium_FindDuplicateNumber_287 {
    // 思路：和442很像，注意到 1 <= nums[i] <= n，可以把nums[i]中的元素创立一个到其index的映射
    // map数组记录每个ith元素的个数，返回次数>=2的即可
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int[] map = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            map[nums[i] - 1]++;
        }

        for(int i = 0; i < map.length; i++){
            if(map[i] >= 2){
                return i+1;
            }
        }
        return -1;
    }

    // 思路：Binary Search: 由于1 <= nums[i] <= n，
    public int findDuplicate_v2(int[] nums){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            int count = 0;
            for(int i: nums){
                if(i <= mid){
                    count++;
                }
            }
            if(count <= mid){
                low = mid + 1;
            } else{
                high = mid;
            }
        }
        return low;
    }
}
