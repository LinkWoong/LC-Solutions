package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

    The binary search tree is guaranteed to have unique values.
    Example 1:

    Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
    Output: 32
    Example 2:

    Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
    Output: 23


    Note:

    The number of nodes in the tree is at most 10000.
    The final answer is guaranteed to be less than 2^31.
 */
public class Medium_RangesumOfBST_938 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        List<Integer> res = new ArrayList<>();
        int sum = 0;
        helper(root, res, L, R);
        for(Integer i : res)
            sum += i;
        return sum;
    }

    private void helper(TreeNode node, List<Integer> res, int L, int R){
        if(node == null)
            return;
        else{
            if(node.val >= L && node.val <= R){
                res.add(node.val);
            }
            helper(node.left, res, L, R);
            helper(node.right, res, L, R);
        }
    }
}
