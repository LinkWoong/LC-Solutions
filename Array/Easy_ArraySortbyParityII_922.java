package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
    Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

    Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

    You may return any answer array that satisfies this condition.
    Example 1:

    Input: [4,2,5,7]
    Output: [4,5,2,7]
    Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.

    Note:

    2 <= A.length <= 20000
    A.length % 2 == 0
    0 <= A[i] <= 1000
 */
public class Easy_ArraySortbyParityII_922 {

    public static void main(String[] args){
        int[] nums = {4, 2,  5, 7};
        int[] res = sortArrayByParityII(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] sortArrayByParityII(int[] nums){
        Stack<Integer> odd = new Stack<>();
        Stack<Integer> even = new Stack<>();
        int[] res = new int[nums.length];
        for (int num : nums) {
            if (num % 2 == 0)
                even.add(num);
            else
                odd.add(num);
        }

        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0)
                res[i] = even.pop();
            else
                res[i] = odd.pop();
        }
        return res;
    }
}
