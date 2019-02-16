package Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Easy_TwoSum_1 {
    public static void main(String[] args){
        int[] nums = {2, 7, 11, 15};
        int[] res = twoSum_v2(nums, 9);
        System.out.println(Arrays.toString(res));
    }

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

    // 思路：注意到nums是一个sorted array：
    // 如果target - nums[i]在map中，说明target = nums[i] + map.get(target - nums[i])
    // 否则将nums[i]和i放到map中去
    public static int[] twoSum_v2(int[] nums, int target){
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                res[1] = i;
                res[0] = map.get(target - nums[i]);
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
