package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
    You need to find the largest value in each row of a binary tree.

    Example:
    Input:

              1
             / \
            3   2
           / \   \
          5   3   9

    Output: [1, 3, 9]

 */
public class Medium_FindLargetsInRow_515 {
    // 思路：和429很像，还是需要用到层序遍历。不过需要注意的点有两个
    // 一个是需要先把目前queue的size存起来用来访问每一层的所有元素
    // 二是在遍历每一层的节点找最大值时max需要初始化为Integer.MIN_VALUE
    // 否则遇到比root小的就不会被考虑到
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.remove();
                max = Math.max(max, cur.val);
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
