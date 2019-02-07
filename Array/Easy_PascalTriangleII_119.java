package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

    Note that the row index starts from 0.


    In Pascal's triangle, each number is the sum of the two numbers directly above it.

    Example:

    Input: 3
    Output: [1,3,3,1]
*/
public class Easy_PascalTriangleII_119 {
    // 思路：效仿118，只需要多创建一行，再返回即可
    public List<Integer> getRow(int numRows) {
        if(numRows < 0)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < numRows+1; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < i+1; j++){
                if(j == 0 || j == i)
                    list.add(1);
                else
                    list.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            res.add(list);
        }
        return res.get(numRows);
    }
}
