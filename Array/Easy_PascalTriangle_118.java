package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
    In Pascal's triangle, each number is the sum of the two numbers directly above it.

    Example:

    Input: 5
    Output:
    [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
    ]
*/
public class Easy_PascalTriangle_118 {
    // 思路：两个loop，外层负责row，内层负责col。如果是边界row==col || col == 0就add 1
    // 否则add row-1 行的j-1和j之和（与题目描述保持一致）
    public List<List<Integer>> generate(int numRows) {
        if(numRows <= 0)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < i+1; j++){
                if(j == 0 || j == i)
                    list.add(1);
                else
                    list.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            res.add(list);
        }
        return res;
    }
}
