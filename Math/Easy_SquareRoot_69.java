package Leetcode;
/*
    Implement int sqrt(int x).

    Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

    Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

    Example 1:

    Input: 4
    Output: 2
    Example 2:

    Input: 8
    Output: 2
    Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 */
public class Easy_SquareRoot_69 {
    // 思路：很naive的binary search解法。
    // 首先设定lower, upper界限，更新mid的时候用(high + low) / 2 （或者low + (high - low) / 2，防止一个Corner case导致的溢出）
    // 如果mid小于x除以mid，说明答案在右半部分。将lower bound+1；反之将upper bound-1。
    // 最后当下界超过上界时退出循环。
    
    public int mySqrt(int x) {
        if(x == 0)
            return x;
        int low = 1, high = x, ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(mid <= x / mid){
                low = mid + 1;
                ans = mid;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
}
