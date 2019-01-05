package Leetcode;
/*
    A binary tree is univalued if every node in the tree has the same value.

    Return true if and only if the given tree is univalued.

    Example 1:
    Input: [1,1,1,1,1,null,1]
    Output: true


    Example 2:
    Input: [2,2,2,5,2]
    Output: false
 */
public class Easy_isUniValueTree_965 {
    public boolean isUnivalTree(TreeNode root) {
        return helper(root, root.val);
    }

    public boolean helper(TreeNode node, int val){
        if(node == null){
            return true;
        }
        if(node.val != val){
            return false;
        }
        return helper(node.left, val) && helper(node.right, val);
    }
}
