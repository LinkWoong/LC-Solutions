package Leetcode;

import java.util.HashSet;
import java.util.Set;

/*
    Write an algorithm to determine if a number is "happy".

    A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

    Example:

    Input: 19
    Output: true
    Explanation:
    12 + 92 = 82
    82 + 22 = 68
    62 + 82 = 100
    12 + 02 + 02 = 1
 */
public class Easy_HappyNumber_202 {
    // 思路：用Set保存每一次迭代得到的number，如果遇到重复的无法放到
    // Set里就不是happy number
    public boolean isHappy(int n) {
        if(n <= 0){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        while(n != 1){
            n = getSum(n);
            if(!set.add(n)){
                return false;
            }
        }
        return true;
    }

    public int getSum(int n){
        if(n <= 0){
            return 0;
        }
        int sum = 0;
        while(n != 0){
            int res = n % 10;
            sum += res * res;
            n /= 10;
        }
        return sum;
    }
}
