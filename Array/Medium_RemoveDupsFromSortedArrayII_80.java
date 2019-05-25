package Leetcode;
/*
    Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

    Example 1:

    Given nums = [1,1,1,2,2,3],

    Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

    It doesn't matter what you leave beyond the returned length.
    Example 2:

    Given nums = [0,0,1,1,1,1,2,3,3],

    Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

    It doesn't matter what values are set beyond the returned length.
    Clarification:

    Confused why the returned value is an integer but your answer is an array?

    Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

    Internally you can think of this:

    // nums is passed in by reference. (i.e., without making a copy)
    int len = removeDuplicates(nums);

    // any modification to nums in your function would be known by the caller.
    // using the length returned by your function, it prints the first len elements.
    for (int i = 0; i < len; i++) {
        print(nums[i]);
    }
 */
public class Medium_RemoveDupsFromSortedArrayII_80 {
    // 思路：目的是保持每个元素出现次数<=2，用双指针+计数器
    // 当p2和p2-1元素不相等counter reset为1，否则++。当 >= 2时p1停止更新，留在index >= 第三个重复元素
    // p2扫描每个元素，如果p2和p2-1不相等nums[p1]赋值为nums[p2]同时p1右移一位，其实就是把nums[p2]左移
    // 如果相等并且是第二次出现，count++，nums[p1]赋值为nums[p2]，p1右移
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int p1 = 1, p2 = 1;
        int count = 1;
        while(p2 < nums.length){
            if(nums[p2] != nums[p2 - 1]){
                count = 1;
                nums[p1] = nums[p2];
                p1++;
            }
            else{
                if(count < 2){
                    count ++;
                    nums[p1] = nums[p2];
                    p1++;
                }
            }
            p2++;
        }
        return p1;
    }
}
