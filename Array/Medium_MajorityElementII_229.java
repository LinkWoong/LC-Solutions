package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

    Note: The algorithm should run in linear time and in O(1) space.

    Example 1:

    Input: [3,2,3]
    Output: [3]
    Example 2:

    Input: [1,1,1,3,3,2,2,2]
    Output: [1,2]

 */
public class Medium_MajorityElementII_229 {
    // 思路：Moore Vote变种
    public List<Integer> majorityElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int num1 = nums[0], num2 = nums[0], count1 = 1, count2 = 0;
        for(int i: nums){
            if(i == num1){
                count1++;
            } else if(i == num2){
                count2++;
            } else if(count1 == 0){
                num1 = i;
                count1++;
            } else if(count2 == 0){
                num2 = i;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;

        for(int i: nums){
            if(i == num1){
                count1++;
            }
            else if(i == num2){
                count2++;
            }
        }
        if(count1 > nums.length / 3){
            res.add(num1);
        }
        if(count2 > nums.length / 3){
            res.add(num2);
        }
        return res;
    }
}
