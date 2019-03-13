package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */
public class Easy_ConvertSortedArrToBTree_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        TreeNode root = helper(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode helper(int[] nums, int p1, int p2){
        if(p1 > p2){
            return null;
        }
        int mid = p1 + (p2 - p1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, p1, mid - 1);
        root.right = helper(nums, mid + 1, p2);
        return root;
    }

}
