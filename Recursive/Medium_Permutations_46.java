package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    Given a collection of distinct integers, return all possible permutations.

    Example:

    Input: [1,2,3]
    Output:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]

 */
public class Medium_Permutations_46 {
    // 思路：backtracking，对num进行遍历，如果list包含num[i]就跳过，否则make progression，再次调用helper(res, list, nums)
    // 此时list已经有前一次调用的num[i]了，所以只add未出现的元素。
    public static void main(String[] args){
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), nums);
        System.out.println(res);
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
        }
        else{
            for(int i = 0; i < nums.length; i++){
                if(list.contains(nums[i]))
                    continue;
                list.add(nums[i]);
                helper(res, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
