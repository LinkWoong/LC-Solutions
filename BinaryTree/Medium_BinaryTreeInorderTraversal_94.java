package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
    Given a binary tree, return the inorder traversal of its nodes' values.

    Example:

    Input: [1,null,2,3]
       1
        \
         2
        /
       3

    Output: [1,3,2]
    Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class Medium_BinaryTreeInorderTraversal_94 {

    // 递归解法
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    private void helper(TreeNode node, List<Integer> res){
        if(node == null)
            return;
        helper(node.left, res);
        res.add(node.val);
        helper(node.right, res);
    }

    // 非递归解法：
    public List<Integer> inorderTraversal_iterative(TreeNode root){
        if(root == null)
            return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
