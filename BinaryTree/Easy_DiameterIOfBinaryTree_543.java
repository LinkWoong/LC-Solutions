package Leetcode;
/*
    Given a binary tree, you need to compute the length of the diameter of the tree.
    The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
    This path may or may not pass through the root.

    Example:
    Given a binary tree
              1
             / \
            2   3
           / \
          4   5
    Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

    Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class Easy_DiameterIOfBinaryTree_543 {
    // 思路：最长路径存在于root节点或者root.left, root.right三处
    // 利用递归和maxDepth就可以找到最长路径
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int res = 0;
        int cur = helper(root.left) + helper(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);

        return Math.max(cur, Math.max(left, right));
    }

    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(helper(root.left), helper(root.right)) + 1;
    }
}
