package Leetcode;
/*
    Given a binary search tree and the lowest and highest boundaries as L and R,
    trim the tree so that all its elements lies in [L, R] (R >= L).
    You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

    Example 1:

    Input:
        1
       / \
      0   2

      L = 1
      R = 2

    Output:
        1
          \
           2
    Example 2:

    Input:
        3
       / \
      0   4
       \
        2
       /
      1

      L = 1
      R = 3

    Output:
          3
         /
       2
      /
     1

 */
public class Easy_TrimBTree_669 {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null)
            return null;
        return helper(root, L, R);
    }

    private TreeNode helper(TreeNode node, int L, int R){
        if(node == null)
            return null;
        else{
            if(node.val < L){
                return helper(node.right, L, R);
            }
            else if(node.val > R){
                return helper(node.left, L, R);
            }
            node.left = helper(node.left, L, R);
            node.right = helper(node.right, L, R);
        }
        return node;
    }
}
