package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given an n-ary tree, return the preorder traversal of its nodes' values.

For example, given a 3-ary tree:
Return its preorder traversal as: [1,3,5,6,2,4].

Note:

Recursive solution is trivial, could you do it iteratively?
*/
public class Easy_NaryTreeTraversal_589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<Integer> preorder(Node root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(Node node, List<Integer> res){
        if(node == null)
            return;
        else{
            res.add(node.val);
            for(Node child : node.children){
                preorder(child, res);
            }
            return;
        }
    }
}

/*
// Definition for a Node.

*/
class Solution {

}
