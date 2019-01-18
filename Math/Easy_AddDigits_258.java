package Leetcode;
/*
    Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

    Example:

    Input: 38
    Output: 2
    Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
                 Since 2 has only one digit, return it.
    Follow up:
    Could you do it without any loop/recursion in O(1) runtime?
 */
public class Easy_AddDigits_258 {

    public int addDigits(int num) {
        int temp = (num / 10) + (num % 10);
        while(temp >= 10){
            temp = (temp / 10) + (temp % 10);
        }
        return temp;
    }
}
