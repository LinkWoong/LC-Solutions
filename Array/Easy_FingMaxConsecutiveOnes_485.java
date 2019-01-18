package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    Given a binary array, find the maximum number of consecutive 1s in this array.

    Example 1:
    Input: [1,1,0,1,1,1]
    Output: 3
    Explanation: The first two digits or the last three digits are consecutive 1s.
        The maximum number of consecutive 1s is 3.

    Note:

    The input array will only contain 0 and 1.
    The length of input array is a positive integer and will not exceed 10,000
 */
public class Easy_FingMaxConsecutiveOnes_485 {
    // 思路：很简单，每次遇见1计数器++，遇见0再清零。最后选取最大的计数即可
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num == 1)
                res++;
            else if (num == 0) {
                list.add(res);
                res = 0;
            }
        }

        for(int i = 0; i < list.size(); i++){
            if(res < list.get(i))
                res = list.get(i);
        }
        return res;
    }
}
