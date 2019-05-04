package Leetcode;

import java.util.Stack;
/*
    Given a Binary Search Tree (BST), convert it to a Greater Tree such that
    every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

    Example:

    Input: The root of a Binary Search Tree like this:
                  5
                /   \
               2     13

    Output: The root of a Greater Tree like this:
                 18
                /   \
              20     13
 */
public class Easy_ConvertBTreeToGreater_538 {
    // 思路：和Path sum I很相似，都是通过update current node value来实现累加的
    // 用一个reversed 前序遍历就可以达到目的。
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int sum = 0;
        while(cur!= null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            int temp = cur.val;
            cur.val += sum;
            sum += temp;
            cur = cur.left;
        }
        return root;
    }
}
