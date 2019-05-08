package Leetcode;

import java.util.LinkedList;
import java.util.Queue;
/*
    Given a binary tree, find the leftmost value in the last row of the tree.

    Example 1:
    Input:

        2
       / \
      1   3

    Output:
    1
    Example 2:
    Input:

            1
           / \
          2   3
         /   / \
        4   5   6
           /
          7

    Output:
    7
    Note: You may assume the tree (i.e., the given root node) is not NULL.
 */
public class Medium_FindBottomLeftValue_513 {
    // 思路：进行Level Order遍历，注意要先放右节点再放左节点，当前节点为根节点时并且队列为空返回节点值
    public int findBottomLeftValue(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.remove();
            if(cur.right != null){
                queue.add(cur.right);
            }
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.left == null && cur.right == null && queue.isEmpty()){
                return cur.val;
            }
        }
        return -1;
    }
}
