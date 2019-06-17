package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    The gray code is a binary numeral system where two successive values differ in only one bit.

    Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

    Example 1:

    Input: 2
    Output: [0,1,3,2]
    Explanation:
    00 - 0
    01 - 1
    11 - 3
    10 - 2

    For a given n, a gray code sequence may not be uniquely defined.
    For example, [0,2,3,1] is also a valid gray code sequence.

    00 - 0
    10 - 2
    11 - 3
    01 - 1
    Example 2:

    Input: 0
    Output: [0]
    Explanation: We define the gray code sequence to begin with 0.
                 A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
                 Therefore, for n = 0 the gray code sequence is [0].
 */
public class Medium_GrayCode_89 {
    // 思路：和subset一样的思路，重点是给一个数字如何找到和它binary representation相差一位的数字
    // 1 << i OR上该数字即可（stolen from discussion）
    public List<Integer> grayCode(int n) {
        if(n < 0){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for(int i = 0; i < n; i++){
            int size = res.size();
            for(int j = size - 1; j >= 0; j--){
                int temp = res.get(j) | 1 << i;
                res.add(temp);
            }
        }
        return res;
    }
}
