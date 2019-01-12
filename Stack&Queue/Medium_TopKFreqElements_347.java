package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/*
    Given a non-empty array of integers, return the k most frequent elements.

    Example 1:

    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]
    Example 2:

    Input: nums = [1], k = 1
    Output: [1]
    Note:

    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class Medium_TopKFreqElements_347 {

    private class Freq implements Comparable<Freq>{
        int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }
        @Override
        public int compareTo(Freq o) {
            if(this.freq < o.freq)
                return -1;
            else if(this.freq > o.freq)
                return 1;
            else
                return 0;
        }
    }
    // time o(nlogm), 使用基于最小堆的优先队列
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for(int key: map.keySet()){
            if(pq.size() < k) // 如果pq不满，加到k个
                pq.add(new Freq(key, map.get(key)));
            else if(map.get(key) > pq.peek().freq){ // 如果新的元素freq比队列中最小的一个元素要大，替换之
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty())
            res.add(pq.remove().e);

        return res;
    }
}
