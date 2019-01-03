package Leetcode;

import java.util.Arrays;

/*
    Given a positive integer, check whether it has alternating bits:
    namely, if two adjacent bits will always have different values.

    Example 1:
    Input: 5
    Output: True
    Explanation:
    The binary representation of 5 is: 101

    Example 2:
    Input: 7
    Output: False
    Explanation:
    The binary representation of 7 is: 111.

    Example 3:
    Input: 11
    Output: False
    Explanation:
    The binary representation of 11 is: 1011.

    Example 4:
    Input: 10
    Output: True
    Explanation:
    The binary representation of 10 is: 1010.
 */
public class Easy_BinaryNumWithAlterBits_693 {
    public static void main(String[] args){
        System.out.println(hasAlternatingBits(10));
    }

    // Bitwise operation
    // Runtime: 17 ms, faster than 2.17% of Java online submissions
    public static boolean hasAlternatingBits(int n) {
        int[] res = new int[(int) (Math.floor(Math.log(n) / Math.log(2))) + 1];
        int status = 0;
        for(int i = 0; i < res.length; i++){
            res[i] = n % 2;
            n = n / 2;
        }
        System.out.println(Arrays.toString(res));
        for(int i = 0; i < res.length - 1; i++){
            if((res[i] ^ res[i+1]) == 0)
                status++;

        }
        return status == 0;
    }
}
