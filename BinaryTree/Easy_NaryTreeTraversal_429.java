package Leetcode;

import Leetcode.Easy_NaryTreeTraversal_589.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

    For example, given a 3-ary tree:

    We should return its level order traversal:

    [
         [1],
         [3,2,4],
         [5,6]
    ]
*/
public class Easy_NaryTreeTraversal_429 {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null)
            return null;
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();

            for(int i = 0; i < size; i++){
                Node cur = queue.remove();
                temp.add(cur.val);
                for(Node child: cur.children)
                    queue.add(child);
            }
            res.add(temp);
        }
        return res;
    }
}

