package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree,
and every node has no left child and only 1 right child.

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9
Note:

The number of nodes in the given tree will be between 1 and 100.
Each node will have a unique integer value from 0 to 1000.
*/
public class Easy_IncreasingOrderBST_897 {
    private TreeNode res;
    private TreeNode pre;

    public TreeNode increasingBST(TreeNode root) {
        if(root == null)
            return null;
        helper(root);
        return res;
    }

    // 中序bfs遍历拿到排序后的节点，再重新创造一颗worse case二叉树. time: o(n)
    private void helper(TreeNode node){
        if(node == null)
            return;
        helper(node.left);
        if(res == null){ // 到达最小值
            res = node; // assign to res
        }
        else{ // 否则
            pre.right = node;
        }
        pre = node; // merge two nodes
        node.left = null;
        helper(node.right);
    }
}
