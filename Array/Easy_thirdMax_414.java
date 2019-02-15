package Leetcode;

import java.util.*;

public class Easy_thirdMax_414 {
    // 思路：利用优先队列直接出结果，要注意队列size == 0的情况
    public int thirdMax(int[] nums) {
        // Comparator<Integer> comparator = new helper();
        // PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            if(!set.contains(i)){
                queue.add(i);
                set.add(i);
                if(queue.size() > 3){
                    set.remove(queue.poll());
                }
            }
        }

        if(queue.size() < 3){
            while(queue.size() > 1)
                queue.poll();
        }
        return queue.size() == 0 ? -1 : queue.peek();
    }

    static class helper implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }
}
