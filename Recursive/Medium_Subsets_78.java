package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    Given a set of distinct integers, nums, return all possible subsets (the power set).
    Note: The solution set must not contain duplicate subsets.
    Example:

    Input: nums = [1,2,3]
    Output:
    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]
*/
public class Medium_Subsets_78 {
    // 思路：从res=[[]]开始遍历每个元素，以subset=[[]]开始添加元素，同时keep tracking on res.length
    // 将每个增长后的subset加入到res中
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        // System.out.println(res);
        for(int num: nums){
            int size = res.size();
            for(int i = 0; i < size; i++){
                List<Integer> temp = new ArrayList<>(res.get(i));
                temp.add(num);
                res.add(temp);
            }
        }

        return res;
    }
}
