package Leetcode;
/*
    Given a positive integer, output its complement number.
    The complement strategy is to flip the bits of its binary representation.

    Note:

    The given integer is guaranteed to fit within the range of a 32-bit signed integer.
    You could assume no leading zero bit in the integer’s binary representation.
    Example 1:

    Input: 5
    Output: 2
    Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010.
    So you need to output 2.

    Example 2:

    Input: 1
    Output: 0
    Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0.
    So you need to output 0.
 */
public class Easy_NumComplement_476 {
    public static void main(String[] args){
        int num = 9;
        int result = findComplement(num);
        System.out.println(result);
    }

    // Runtime: 9 ms, faster than 24.81% of Java online submissions
    // bit manipulation
    public static int findComplement(int num){
        int bits = (int) (Math.floor(Math.log(num) / Math.log(2))) + 1;
        return ((1 << bits) - 1) ^ num;
    }

    public static int findComplement_v2(int num){
        int complementNumber = 0;
        int multiplair = 1;
        while(num > 0) {
            if(num % 2 == 0) {
                complementNumber += 1*multiplair;
            }
            num = num/2;
            multiplair = multiplair*2;
        }
        return complementNumber;
    }
}
