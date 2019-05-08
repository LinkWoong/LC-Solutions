package Leetcode;
/*
    Given a binary string S (a string consisting only of '0' and '1's) and a positive integer N,
    return true if and only if for every integer X from 1 to N, the binary representation of X is a substring of S.

    Example 1:

    Input: S = "0110", N = 3
    Output: true
    Example 2:

    Input: S = "0110", N = 4
    Output: false
    Note:

    1 <= S.length <= 1000
    1 <= N <= 10^9
 */
public class Medium_BinaryStringWithSubstr_1016 {
    // 思路：很直接的做法，找到[1, N]各个元素的binary representation再check是不是substr即可
    public boolean queryString(String S, int N) {
        for(int i = 1; i <= N; i++){
            String substr = findBinary(i);
            if(!S.contains(substr)){
                return false;
            }
        }
        return true;
    }
    public String findBinary(int digit){
        StringBuilder res = new StringBuilder();
        while(digit > 0){
            res.insert(0, digit % 2);
            digit /= 2;
        }
        return res.toString();
    }
}
