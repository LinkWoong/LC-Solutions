package Leetcode;
import java.util.Stack;
/*
    Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

    Note: A leaf is a node with no children.

    Example:

    Given the below binary tree and sum = 22,

          5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1
    return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class Easy_PathSum_112 {
    // 思路：前序遍历。把每个节点的值加到下一个非null的节点上
    // 再在根节点处判断是否等于sum即可
    // 用递归会更快一些
    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty() && root != null){
            TreeNode cur = stack.pop();
            if(cur.right == null && cur.left == null){
                if(cur.val == sum){
                    return true;
                }
            }
            if(cur.right != null){
                cur.right.val += cur.val;
                stack.push(cur.right);
            }
            if(cur.left != null){
                cur.left.val += cur.val;
                stack.push(cur.left);
            }
        }

        return false;
    }
}
