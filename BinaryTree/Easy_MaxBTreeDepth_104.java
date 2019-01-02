package Leetcode;

import java.util.Stack;

/*
    Given a binary tree, find its maximum depth.

    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    Note: A leaf is a node with no children.

    Example:

    Given binary tree [3,9,20,null,null,15,7],

        3
       / \
      9  20
        /  \
       15   7
    return its depth = 3.
 */
public class Easy_MaxBTreeDepth_104 {
    public int depth = 0;
    public static void main(String[] args){

    }

    // depth-first search
    // Runtime: 1 ms, faster than 29.91% of Java online submissions
    public int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        else{
            int res1 = maxDepth(root.left);
            int res2 = maxDepth(root.right);

            if(res1 > res2)
                return res1 + 1;
            else
                return res2 + 1;
        }
    }

    public int maxDepth_v2(TreeNode root){
        dfs(root, 1);
        return depth;
    }

    private void dfs(TreeNode node, int val){
        if(node != null){
            depth = Math.max(depth, val);
            dfs(node.left, val+1);
            dfs(node.right, val+1);
        }
    }
}
