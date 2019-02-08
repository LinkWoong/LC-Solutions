package Leetcode;

import java.util.HashMap;

/*
    You are climbing a stair case. It takes n steps to reach to the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    Note: Given n will be a positive integer.

    Example 1:

    Input: 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps
    Example 2:

    Input: 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step
 */
public class Easy_ClimbStairs_70 {
    // 思路：观察sequence发现在n<4时，num_of_stairs=n；在n>4时，num_of_stairs=S(n-1) + S(n-2)即前两项的和
    // 是一个向右平移后的Fib sequence，直接用递归解法
    // 加了一个缓冲cache，目的是防止重复的无用计算
    private HashMap<Integer, Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        if(cache.containsKey(n))
            return cache.get(n);
        int result;
        if(n < 4)
            result = n;
        else{
            result = climbStairs(n-1) + climbStairs(n-2);
        }
        cache.put(n, result);
        return result;
    }
}
