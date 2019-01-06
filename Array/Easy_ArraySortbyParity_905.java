package Leetcode;

import java.util.*;

/*
    Given an array A of non-negative integers, return an array consisting of all the even elements of A,
    followed by all the odd elements of A.

    You may return any answer array that satisfies this condition.

    Example 1:
    Input: [3,1,2,4]
    Output: [2,4,3,1]
    The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

    Note:

    1 <= A.length <= 5000
    0 <= A[i] <= 5000
 */
public class Easy_ArraySortbyParity_905 {
    public static void main(String[] args){
        int[] A = {3, 1, 2, 4};
        int[] res = sortArrayByParity(A);
        System.out.println(Arrays.toString(res));
    }

    // Runtime: 24 ms, faster than 9.13% of Java online submissions
    public static int[] sortArrayByParity(int[] A) {
        Stack<Integer> odd = new Stack<>();
        Stack<Integer> even = new Stack<>();
        int[] res = new int[A.length];

        for(int i : A){
            if(i % 2 == 0)
                even.add(i);
            else
                odd.add(i);
        }

        int even_size = even.size();
        int odd_size = odd.size();
        for(int i = 0; i < even_size; i++){
            res[i] = even.pop();
        }

        for(int i = even_size; i < odd_size + even_size; i++){
            res[i] = odd.pop();
        }
        return res;
    }
}
