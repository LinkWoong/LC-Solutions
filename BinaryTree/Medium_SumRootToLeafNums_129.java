package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
    Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

    An example is the root-to-leaf path 1->2->3 which represents the number 123.

    Find the total sum of all root-to-leaf numbers.

    Note: A leaf is a node with no children.

    Example:

    Input: [1,2,3]
        1
       / \
      2   3
    Output: 25
    Explanation:
    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.
    Therefore, sum = 12 + 13 = 25.
    Example 2:

    Input: [4,9,0,5,1]
        4
       / \
      9   0
     / \
    5   1
    Output: 1026
    Explanation:
    The root-to-leaf path 4->9->5 represents the number 495.
    The root-to-leaf path 4->9->1 represents the number 491.
    The root-to-leaf path 4->0 represents the number 40.
    Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class Medium_SumRootToLeafNums_129 {
    // 思路：层序遍历到每个元素时，加上父节点的value（注意要parse为int或者直接*10），最后加到根节点即可
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return root.val;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            // System.out.println(current.val);
            if(current.left != null){
                String temp = Integer.toString(current.val) + Integer.toString(current.left.val);
                current.left.val = Integer.parseInt(temp);
                if(current.left.left == null && current.left.right == null){
                    res += current.left.val;
                }
                queue.add(current.left);
            }
            if(current.right != null){
                String temp = Integer.toString(current.val) + Integer.toString(current.right.val);
                current.right.val = Integer.parseInt(temp);
                if(current.right.left == null && current.right.right == null){
                    res += current.right.val;
                }
                queue.add(current.right);
            }
        }
        return res;
    }
}
