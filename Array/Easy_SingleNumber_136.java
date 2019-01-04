package Leetcode;

import java.util.HashMap;

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
        int res = singleNumber(nums);
        System.out.println(res);
    }

    // HashMap计算每个entry的数量即可
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
}
