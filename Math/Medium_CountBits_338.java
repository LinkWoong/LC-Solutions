package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
    Given a non negative integer number num.
    For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

    Example 1:

    Input: 2
    Output: [0,1,1]
    Example 2:

    Input: 5
    Output: [0,1,1,2,1,2]
    Follow up:

    It is very easy to come up with a solution with run time O(n*sizeof(integer)).
    But can you do it in linear time O(n) /possibly in a single pass?
    Space complexity should be O(n).
    Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

 */
public class Medium_CountBits_338 {

    public static void main(String[] args){
        int num = 5;
        int[] res = countBits(num);
        System.out.println(Arrays.toString(res));
    }

    public static int[] countBits(int num) {
        int[] res = new int[num + 1];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= num; i++)
            list.add(i);
        for(int i = 0; i <= list.size() - 1; i++){
            Integer val = list.get(i);
            int count = 0;
            while(val > 0){
                if(val % 2 == 1)
                    count++;
                val = val / 2;
            }
            res[i] = count;
        }
        return res;
    }
}
