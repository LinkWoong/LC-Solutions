package Leetcode;

import java.util.HashMap;
import java.util.Map;

/*
    Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

    You may assume that the array is non-empty and the majority element always exist in the array.

    Example 1:

    Input: [3,2,3]
    Output: 3
    Example 2:

    Input: [2,2,1,1,1,2,2]
    Output: 2
 */
public class Easy_MajorityElement_169 {
    // 思路：计算每个元素出现次数，返回符合条件的即可
    public int majorityElement(int[] nums) {
        int n = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            if(!map.containsKey(i))
                map.put(i, 1);
            else
                map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(Integer key: map.keySet()){
            if(map.get(key) > n)
                return key;
        }
        return -1;
    }
}
