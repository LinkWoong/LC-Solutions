package Leetcode;
/*
    Consider all the leaves of a binary tree.
    From left to right order, the values of those leaves form a leaf value sequence.

    For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
    Two binary trees are considered leaf-similar if their leaf value sequence is the same.

    Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

    Note:
    Both of the given trees will have between 1 and 100 nodes.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Easy_LeafSimilarTrees_872 {
    // 一种全新的得到从左往右的根节点值的方法
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == root2){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root1);
        s2.push(root2);

        while(!s1.isEmpty() || !s2.isEmpty()){
            TreeNode cur1 = s1.pop();
            while(cur1.left != null || cur1.right != null){
                if(cur1.left != null){
                    if(cur1.right != null){
                        s1.push(cur1.right);
                    }
                    cur1 = cur1.left;
                } else{
                    cur1 = cur1.right;
                }
            }

            TreeNode cur2 = s2.pop();
            while(cur2.left != null || cur2.right != null){
                if(cur2.left != null){
                    if(cur2.right != null){
                        s2.push(cur2.right);
                    }
                    cur2 = cur2.left;
                } else{
                    cur2 = cur2.right;
                }
            }
            if(cur1.val != cur2.val){
                return false;
            }
        }
        return true;
    }
    // Runtime: 5 ms, faster than 13.35% of Java online submissions
    // Depth-First Search
    public boolean leafSimilar_v3(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> res1 = new ArrayList<>();
        ArrayList<Integer> res2 = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        st1.push(root1);

        while(!st1.isEmpty()){
            TreeNode node = st1.pop();
            if(node.left != null){
                st1.add(node.left);
            }
            if(node.right != null){
                st1.add(node.right);
            }
            if(node.left == null && node.right == null){
                res1.add(node.val);
            }
        }

        Stack<TreeNode> st2 = new Stack<>();
        st2.push(root2);

        while(!st2.isEmpty()){
            TreeNode node = st2.pop();
            if(node.left != null){
                st2.add(node.left);
            }
            if(node.right != null){
                st2.add(node.right);
            }
            if(node.right == null && node.left == null){
                res2.add(node.val);
            }
        }
        return res1.equals(res2);
    }

    public static boolean leafSimilar_v2(TreeNode root1, TreeNode root2){
        ArrayList<Integer> res1 = new ArrayList<>();
        ArrayList<Integer> res2 = new ArrayList<>();
        findLeaves(root1, res1);
        findLeaves(root2, res2);

        return res1.equals(res2);
    }

    public static void findLeaves(TreeNode root, List<Integer> values){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            values.add(root.val);
            return;
        }

        findLeaves(root.left, values);
        findLeaves(root.right, values);

        return;
    }
}

