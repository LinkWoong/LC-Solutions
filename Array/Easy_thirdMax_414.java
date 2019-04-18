package Leetcode;

import java.util.*;

public class Easy_thirdMax_414 {
    // 思路：利用优先队列直接出结果，要注意队列size == 0的情况
    public static int thirdMax(int[] nums) {
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
        System.out.println(queue);
        if(queue.size() < 3){
            while(queue.size() > 1)
                queue.poll();
        }
        return queue.size() == 0 ? -1 : queue.peek();
    }

    public static int thirdMax_v2(int[] nums){
        Integer max1 = null, max2 = null, max3 = null;
        for(Integer i: nums){
            if(i.equals(max1) || i.equals(max2) || i.equals(max3)){
                continue;
            }
            else{
                if(max1 == null || i > max1){
                    max3 = max2;
                    max2 = max1;
                    max1 = i;
                } else if(max2 == null || i > max2){
                    max3 = max2;
                    max2 = i;
                } else if(max3 == null || i > max3){
                    max3 = i;
                }
            }
        }
        return max3 == null ? max1 : max3;
    }
}
