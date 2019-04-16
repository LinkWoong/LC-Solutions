package Leetcode;

import java.util.Stack;

/*
    Given a binary tree, determine if it is a valid binary search tree (BST).

    Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
    Example 1:

    Input:
        2
       / \
      1   3
    Output: true
    Example 2:

        5
       / \
      1   4
         / \
        3   6
    Output: false
    Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
                 is 5 but its right child's value is 4.
 */
public class Medium_ValidateBTree_98 {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev != null && prev.val >= root.val)
                return false;
            prev = root;
            root = root.right;
        }
        return true;
    }

    public boolean isValidBST_recursive(TreeNode root){
        if(root == null)
            return true;
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, TreeNode min, TreeNode max){
        if(node == null)
            return true;
        if(min != null && node.val <= min.val){
            return false;
        }
        if(max != null && node.val >= max.val){
            return false;
        }
        return helper(node.left, min, node) && helper(node.right, node, max);
    }
}
