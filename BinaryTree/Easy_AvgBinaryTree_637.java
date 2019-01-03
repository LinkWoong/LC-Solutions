package Leetcode;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
    Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
    Example 1:

    Input:
        3
       / \
      9  20
        /  \
       15   7
    Output: [3, 14.5, 11]
    Explanation:
    The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
    Note:

    The range of node's value is in the range of 32-bit signed integer.
 */
public class Easy_AvgBinaryTree_637 {

    // 层序遍历。遍历每一层时记录下节点个数和值即可
    // BFS
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Double> res = new ArrayList<>();
        queue.add(root);

        while(queue.size() != 0){
            long sumCurrentLevel = 0;
            int countCurrentLevel = queue.size();

            for(int i = 0; i < countCurrentLevel; i++){
                TreeNode current = queue.poll();
                sumCurrentLevel += current.val;
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
            if(countCurrentLevel != 0){
                res.add((double) sumCurrentLevel / countCurrentLevel);
            }
        }
        return res;
    }


}
