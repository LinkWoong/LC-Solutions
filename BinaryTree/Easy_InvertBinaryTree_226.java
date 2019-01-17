package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
    Invert a binary tree.

    Example:

    Input:

         4
       /   \
      2     7
     / \   / \
    1   3 6   9
    Output:

         4
       /   \
      7     2
     / \   / \
    9   6 3   1
    Trivia:
    This problem was inspired by this original tweet by Max Howell:

    Google: 90% of our engineers use the software you wrote (Homebrew),
    but you can’t invert a binary tree on a whiteboard so f*** off.
 */
public class Easy_InvertBinaryTree_226 {

    // 思路：递归解法，每次递归时把root.left, root.right存起来，再传到下一次递归。
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = invertTree(right);
        root.right = invertTree(left);

        return root;
    }

    // 思路：非递归解法，用层序遍历的方式访问每个节点，再赋值即可。最后再把node.left, node.right入队
    public TreeNode invertTree_nonrecursive(TreeNode root){
        if(root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            TreeNode leftnode = node.left;
            TreeNode rightnode = node.right;

            node.left = rightnode;
            node.right = leftnode;

            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }

        return root;
    }


}
