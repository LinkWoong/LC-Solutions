package Leetcode;

import Leetcode.Easy_NaryTreeTraversal_589.Node;

/*
    Given a n-ary tree, find its maximum depth.

    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    For example, given a 3-ary tree:






    We should return its max depth, which is 3.



    Note:

    The depth of the tree is at most 1000.
    The total number of nodes is at most 5000.
 */
public class Easy_MaxDepthofNaryTree_559 {
    private int depth = 0;
    public int maxDepth(Node root) {
        if(root == null)
            return 0;
        helper(root, 1);
        return depth;
    }

    private void helper(Node node, int val){
        if(node == null)
            return;
        else{
            depth = Math.max(depth, val);
            for(Node child: node.children){
                helper(child, val+1);
            }
        }
    }
}
