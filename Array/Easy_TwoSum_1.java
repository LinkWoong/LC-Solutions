package Leetcode;

import java.util.HashMap;

public class Easy_TwoSum_1 {
    // 思路：很笨的o(nlogn)方法，对每个nums[i]，访问其以后的每个元素并计算sum。如果sum为target，记录下index
    public int[] twoSum(int[] nums, int target){
        int idx1 = -1, idx2 = -1;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                if(sum == target){
                    idx1 = i;
                    idx2 = j;
                }
            }
        }
        int[] res = new int[2];
        res[0] = idx1;
        res[1] = idx2;
        return res;
    }
}
