package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
    Given two arrays, write a function to compute their intersection.

    Example 1:

    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2,2]
    Example 2:

    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [4,9]
    Note:

    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.
 */
public class Easy_IntersectOfArraysII_350 {
    public static void main(String[] args){
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = intersection(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    // 思路：先把第一个数组每个元素及其出现次数放到HashMap中
    // 再在第二个数组中检索，如果找到了map对应的值就-1
    // 最后再转成primitive type int[]
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i]))
                map.put(nums1[i], map.get(nums1[i])+1);
            else
                map.put(nums1[i], 1);
        }

        for(int i = 0; i < nums2.length; i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                res.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }

        int[] arr = new int[res.size()];
        for(int i = 0; i < arr.length; i++)
            arr[i] = res.get(i);

        return arr;
    }
}
