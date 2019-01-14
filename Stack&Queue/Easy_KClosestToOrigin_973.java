package Leetcode;

import Algorithm.ArrayWrapper;

import java.util.*;

/*
    We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
    (Here, the distance between two points on a plane is the Euclidean distance.)
    You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

    Example 1:

    Input: points = [[1,3],[-2,2]], K = 1
    Output: [[-2,2]]
    Explanation:
    The distance between (1, 3) and the origin is sqrt(10).
    The distance between (-2, 2) and the origin is sqrt(8).
    Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
    We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
    Example 2:

    Input: points = [[3,3],[5,-1],[-2,4]], K = 2
    Output: [[3,3],[-2,4]]
    (The answer [[-2,4],[3,3]] would also be accepted.)


    Note:

    1 <= K <= points.length <= 10000
    -10000 < points[i][0] < 10000
    -10000 < points[i][1] < 10000

 */
public class Easy_KClosestToOrigin_973 {

    // 思路：利用优先队列和自己实现的比较器来进行distance的区分。优先队列设置为是distance小的优先级高，和题目描述保持一致
    // 遍历每个subarray, 计算其distance^2再放到HashMap<Integer[], Integer>中。
    // 对于HashMap中的每个键，如果优先队列未满（即size < K）就放入该键和对应的distance（通过new了一个对象来实现的）
    // 如果满了，就比较最先入队的元素distance和目前元素的distance大小。如果目前更小则替换之。
    private static class distance implements Comparable<distance>{
        int[] num;
        int d;

        public distance(int[] num, int d){
            this.num = num;
            this.d = d;
        }

        @Override
        public int compareTo(distance o) {
            if(this.d > o.d)
                return -1;
            else if(this.d < o.d)
                return 1;
            else
                return 0;
        }
    }

    public static void main(String[] args){
        int[][] points = {{3,3}, {5,-1}, {-2,4}};
        int[][] res = kClosest(points, 2);
        System.out.println(Arrays.toString(res[0]) + Arrays.toString(res[1]));
    }

    public static int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][2];
        int[] distance = new int[points.length];
        Map<int[], Integer> hm = new HashMap<>();
        for(int i = 0; i < points.length; i++){
            distance[i] = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            hm.put(points[i], distance[i]);
        }
        PriorityQueue<distance> pq = new PriorityQueue<>();
        for(int[] num : hm.keySet()){
            if(pq.size() < K)
                pq.add(new distance(num, hm.get(num)));
            else if(hm.get(num) < pq.peek().d){
                pq.remove();
                pq.add(new distance(num, hm.get(num)));
            }
        }
        for(int i = 0; i < K; i++)
            res[i] = pq.remove().num;
        return res;
    }
}
