package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
    Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

    The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
    If it does not exist, output -1 for this number.

    Example 1:
    Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
    Output: [-1,3,-1]
    Explanation:
        For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
        For number 1 in the first array, the next greater number for it in the second array is 3.
        For number 2 in the first array, there is no next greater number for it in the second array, so output -1.

    Example 2:
    Input: nums1 = [2,4], nums2 = [1,2,3,4].
    Output: [3,-1]
    Explanation:
        For number 2 in the first array, the next greater number for it in the second array is 3.
        For number 4 in the first array, there is no next greater number for it in the second array, so output -1.

    Note:
    All elements in nums1 and nums2 are unique.
    The length of both nums1 and nums2 would not exceed 1000.
 */
public class Easy_NextGreaterElement_496 {

    // 思路：题目描述有歧义，corresponding places指的不是index，而是value对应的position。例如[4, 1, 2]中的4对应[1, 3, 4, 2]中的[4, 2]
    // 先用一个index记录所有nums1 value在nums2对应的index。再
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        int n = nums1.length;
        int[] index = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums2[j] == nums1[i])
                    index[i] = j;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = index[i]; j <= nums2.length - 1; j++){
                if(nums2[j] > nums1[i]){
                    res.add(nums2[j]);
                    break;
                }
                else if(j == nums2.length - 1)
                    res.add(-1);
            }
        }

        for(int i = 0; i < n; i++)
            index[i] = res.get(i);
        return index;
    }
}
