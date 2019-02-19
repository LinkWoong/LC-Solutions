package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
    Given a non-empty array of integers, every element appears twice except for one. Find that single one.

    Note:

    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

    Example 1:

    Input: [2,2,1]
    Output: 1
    Example 2:

    Input: [4,1,2,1,2]
    Output: 4
 */
public class Easy_SingleNumber_136 {
    public static void main(String[] args){
        int[] nums = {4, 1, 2, 1, 2};
        int res = singleNumber_v3(nums);
        System.out.println(res);
    }

    // 思路1：HashMap计算每个entry的数量即可
    // Runtime: 22 ms, faster than 9.88% of Java online submissions
    public static int singleNumber(int[] nums){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int res = 0;
        for(int num : nums){
            if(!hm.containsKey(num))
                hm.put(num, 1);
            else{
                Integer value = hm.get(num);
                if(value == null)
                    value = 0;
                value++;
                hm.put(num, value);
            }
        }

        for(Integer i : hm.keySet()){
            if(hm.get(i).equals(1))
                res = i;
        }
        return res;
    }

    // 思路2：两个相同的数字做XOR结果不变，可以利用这一点
    // 将res与每个元素做XOR，返回res
    public static int singleNumber_v2(int[] nums){
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    // 思路3：利用哈希表
    public static int singleNumber_v3(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums){
            if(!set.add(i))
                set.remove(i);
        }
        return set.iterator().next();
    }
}
