package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

    Example:

    Input: n = 4, k = 2
    Output:
    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]

 */
public class Medium_Combinations_77 {
    // 思路：和permutation非常相似，只不过要加一个start pos进行dfs
    // start pos是由n决定的
    public List<List<Integer>> combine(int n, int k) {
        if(k == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        // int[] nums = new int[n];
        // for(int i = 0; i < n; i++){
        //    nums[i] = i + 1;
        // }
        helper(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int start, int n, int k){
        if(k == 0){
            res.add(new ArrayList<>(list));
        } else{
            for(int i = start; i <= n; i++){
                list.add(i);
                helper(res, list, i + 1, n, k - 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
