package Leetcode;

import java.util.ArrayList;
import java.util.List;
/*
    Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

    Find all the elements that appear twice in this array.

    Could you do it without extra space and in O(n) runtime?

    Example:
    Input:
    [4,3,2,7,8,2,3,1]

    Output:
    [2,3]
 */

public class Medium_FindAllDupsinArray_442 {
    // 思路：注意到nums[i]大小被限制在[1, nums.length]之间，所以可以用mapping的方式来得到map[nums[i] - 1]出现的次数
    // 再遍历map取出元素为2的即可
    public List<Integer> findDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int[] map = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            map[nums[i] - 1]++;
        }

        for(int i = 0; i < map.length; i++){
            if(map[i] == 2){
                res.add(i + 1);
            }
        }
        return res;
    }
}
