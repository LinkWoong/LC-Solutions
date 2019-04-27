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
    // 思路：利用了Boyer-Moore majority vote算法
    // 从index为1的元素开始sweep，如果nums[i]和major一样，count++
    // 否则count--；当count为0时把major替换为当前元素nums[i]
    public int majorityElement(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int major = nums[0], count = 1;
        for(int i = 1; i < nums.length; i++){
            if(count == 0){
                count++;
                major = nums[i];
            } else if(major == nums[i]){
                count++;
            } else{
                count--;
            }
        }
        return major;
    }
    // 思路：计算每个元素出现次数，返回符合条件的即可
    public int majorityElement_v2(int[] nums) {
        int n = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums) {
            if (!map.containsKey(i))
                map.put(i, 1);
            else
                map.put(i, map.getOrDefault(i, 0) + 1);

            if (map.get(i) > n)
                return i;
        }

        return -1;
    }
}
