package Leetcode;

import java.util.Arrays;

/*
    Given a positive integer N, find and return the longest distance
    between two consecutive 1's in the binary representation of N.
    If there aren't two consecutive 1's, return 0.

    Example 1:

    Input: 22
    Output: 2
    Explanation:
    22 in binary is 0b10110.
    In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
    The first consecutive pair of 1's have distance 2.
    The second consecutive pair of 1's have distance 1.
    The answer is the largest of these two distances, which is 2.

    Example 2:

    Input: 5
    Output: 2
    Explanation:
    5 in binary is 0b101.

    Example 3:

    Input: 6
    Output: 1
    Explanation:
    6 in binary is 0b110.
    Example 4:

    Input: 8
    Output: 0
    Explanation:
    8 in binary is 0b1000.
    There aren't any consecutive pairs of 1's in the binary representation of 8, so we return 0.
    Note:

    1 <= N <= 10^9

 */
public class Easy_BinaryGap_868 {
    // 思路：用辗转相除找到binary representation，再用双指针记录每两个1的index之差，取所有差的最大值即可
    public int binaryGap(int N) {
        int length = (int) (Math.floor(Math.log(N) / Math.log(2))) + 1;
        StringBuilder b = new StringBuilder();
        for(int i = 0; i <= length - 1; i++){
            b.append(N % 2);
            N = N / 2;
        }
        String str = b.reverse().toString();

        int head = str.indexOf('1');
        int tail = str.indexOf('1');
        int temp = str.indexOf('1');
        int res = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '1'){
                head = temp;
                tail = i;
            }
            res = Math.max(tail - head, res);
            temp = tail;
        }
        return res;
    }
}
