Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree [1,2,2,3,4,4,3] is symmetric: 
    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3

Note:
Bonus points if you could solve it both recursively and iteratively. 


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return helper(root.left,root.right);
    }
    private boolean helper(TreeNode Node1, TreeNode Node2){
        if(Node1==null&&Node2==null)
            return true;
        else if(Node1==null||Node2==null)
            return false;
        else if(Node1.val!=Node2.val)
            return false;
        else
            return helper(Node1.left,Node2.right)&&helper(Node1.right,Node2.left);
    }    
}
