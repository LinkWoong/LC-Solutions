package Leetcode;
/*
    We are given two strings, A and B.

    A shift on A consists of taking string A and moving the leftmost character to the rightmost position.
    For example, if A = 'abcde', then it will be 'bcdea' after one shift on A.
    Return True if and only if A can become B after some number of shifts on A.

    Example 1:
    Input: A = 'abcde', B = 'cdeab'
    Output: true

    Example 2:
    Input: A = 'abcde', B = 'abced'
    Output: false
    Note:

    A and B will have length at most 100.
 */
public class Easy_RotateString_796 {
    // 思路：每次将A right shift 1位再和B比较
    // 注意字符串比较用的是obj.equals，而不是 ==
    public boolean rotateString(String A, String B) {
        if(A == null && B == null || A.length() == 0 && B.length() == 0){
            return true;
        }
        int size = A.length();
        for(int i = 0; i < size; i++){
            if(A.equals(B)){
                return true;
            } else{
                A = shiftStringByOneBit(A);
            }
        }
        return false;
    }

    private String shiftStringByOneBit(String str){
        char last = str.charAt(str.length() - 1);
        char[] res = new char[str.length()];
        for(int i = str.length() - 2; i>= 0; i--){
            res[i + 1] = str.charAt(i);
        }
        res[0] = last;
        return new String(res);
    }
}
