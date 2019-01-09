package Leetcode;

import java.util.*;

/*
    Given two arrays, write a function to compute their intersection.

    Example 1:

    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2]
    Example 2:

    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [9,4]
    Note:

    Each element in the result must be unique.
    The result can be in any order.
 */
public class Easy_IntersectOfArrays_349 {
    public static void main(String[] args){
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] res = intersection(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
    // Runtime: 6 ms, faster than 25.55% of Java online submissions
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        for(int i: nums1){
            if(!hm.containsKey(i))
                hm.put(i, 1);
        }
        for(int i: nums2){
            if(hm.containsKey(i))
                hm2.put(i, 1);
        }
        List<Integer> values = new ArrayList<>(hm2.keySet());
        int[] res = new int[hm2.size()];
        for(int i = 0; i < values.size(); i++){
            res[i] = values.get(i);
        }
        return res;
    }
}
