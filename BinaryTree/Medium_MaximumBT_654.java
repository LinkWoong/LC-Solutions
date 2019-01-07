package Leetcode;

import java.util.Arrays;

/*
    Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

    The root is the maximum number in the array.
    The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
    The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
    Construct the maximum tree by the given array and output the root node of this tree.

    Example 1:

    Input: [3,2,1,6,0,5]
    Output: return the tree root node representing the following tree:

          6
        /   \
       3     5
        \    /
         2  0
           \
            1
    Note:

    The size of the given array will be in the range [1,1000].
 */
public class Medium_MaximumBT_654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null)
            return null;
        return helper(nums, 0, nums.length - 1);
    }
    // recursive solution
    private TreeNode helper(int[] nums, int start, int end){
        if(start > end)
            return null;
        int index = start;
        for(int i = index + 1; i <= end; i++){
            if(nums[i] > nums[index])
                index = i;
        }

        TreeNode node = new TreeNode(nums[index]);
        node.left = helper(nums, start, index - 1);
        node.right = helper(nums, index + 1, end);

        return node;
    }

}
