package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
    Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
    Note:
    You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

    Example 1:

    Input: root = [3,1,4,null,2], k = 1
       3
      / \
     1   4
      \
       2
    Output: 1
    Example 2:

    Input: root = [5,3,6,2,4,null,null,1], k = 3
           5
          / \
         3   6
        / \
       2   4
      /
     1
    Output: 3
    Follow up:
    What if the BST is modified (insert/delete operations) often
    and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
public class Medium_KthSmallestBSTElements_230 {
    // 思路：由于是Binary search tree, 特点是左子树永远小于右子树。
    // 所以只需要进行前序遍历，拿到所有val（自动排好序），再取第k-1个元素即可
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res.get(k - 1);
    }

    private void helper(TreeNode node, List<Integer> res){
        if(node == null)
            return;
        helper(node.left, res);
        res.add(node.val);
        helper(node.right, res);
    }
}
