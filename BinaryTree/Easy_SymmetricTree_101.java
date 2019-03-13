package Leetcode;
import java.util.Stack;
/*
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
 */
public class Easy_SymmetricTree_101 {
    // iterative solution
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        if(root.left != null){
            if(root.right == null)
                return false;
            stack.push(root.left);
            stack.push(root.right);
        }
        else if(root.right != null){
            return false;
        }

        while(!stack.isEmpty()){
            if(stack.size() % 2 != 0)
                return false;
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if(left.val != right.val){
                return false;
            }
            if(left.left != null){
                if(right.right == null)
                    return false;
                stack.push(left.left);
                stack.push(right.right);
            }
            else if(right.right != null){
                return false;
            }
            if(left.right != null){
                if(right.left == null)
                    return false;
                stack.push(left.right);
                stack.push(right.left);
            }
            else if(right.left != null){
                return false;
            }
        }
        return true;
    }
    // recursive solution, much more faster
    public boolean isSymmetric_v2(TreeNode root) {
        if(root == null)
            return true;
        else if(root.left == null && root.right == null)
            return true;
        else if(root.left != null && root.right == null)
            return false;
        else if(root.left == null && root.right != null)
            return false;
        else
            return helper(root.left, root.right);
    }

    private boolean helper(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null)
            return true;
        else if(node1.val != node2.val)
            return false;
        else if(node1.left == null && node2.right != null || node1.left != null && node2.right == null ||
                node1.right == null && node2.left != null || node1.right != null && node2.left == null)
            return false;
        if(node1.val != node2.val)
            return false;
        if(node1.val == node2.val && node1.left == null && node2.left == null && node1.right == null && node2.right == null)
            return true;
        boolean res1 = helper(node1.left, node2.right);
        boolean res2 = helper(node1.right, node2.left);
        return res1 && res2;
    }
}
