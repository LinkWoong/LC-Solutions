package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/*
    Given a string, sort it in decreasing order based on the frequency of characters.

    Example 1:

    Input:
    "tree"

    Output:
    "eert"

    Explanation:
    'e' appears twice while 'r' and 't' both appear once.
    So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
    Example 2:

    Input:
    "cccaaa"

    Output:
    "cccaaa"

    Explanation:
    Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
    Note that "cacaca" is incorrect, as the same characters must be together.
    Example 3:

    Input:
    "Aabb"

    Output:
    "bbAa"

    Explanation:
    "bbaA" is also a valid answer, but "Aabb" is incorrect.
    Note that 'A' and 'a' are treated as two different characters.
 */
public class Medium_SortCharacterByFreq_451 {
    private static class charFreq implements Comparable<charFreq>{
        char c;
        int freq;
        public charFreq(char c, int freq){
            this.c = c;
            this.freq = freq;
        }

        @Override
        public int compareTo(charFreq o) {
            if(this.freq < o.freq){
                return 1;
            } else if(this.freq > o.freq){
                return -1;
            } else{
                return 0;
            }
        }
    }
    // 思路：这种按照某种特定需求排序的一般都要用到优先队列，而且自己要写好compareTo方法
    // 对于s中的一个char c，先用Map存储c和其appearances，再wrap到一个自定义类去
    // 这个自定义类一般有多个attributes，第一个是char c的value，第二个是appearances
    // 自定义类实现Comparable接口，在compareTo方法中比较两个类对象的freq值，根据返回值的不同可以对两个类对象进行排序
    // positive, negative and 0分别代表 小于，大于和等于。PriorityQueue根据这个compareTo方法的返回值进行优先级的堆排序
    // 优先级高的，即freq高的出现次数多的先出队。
    public String frequencySort(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        Map<Character, Integer> map = new TreeMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<charFreq> queue = new PriorityQueue<>();
        StringBuilder res = new StringBuilder();
        for(Character key: map.keySet()){
            if(queue.size() < s.length()){
                queue.add(new charFreq(key, map.get(key)));
            }
        }

        while(!queue.isEmpty()){
            charFreq temp = queue.poll();
            for(int i = 0; i < temp.freq; i++){
                res.append(temp.c);
            }
        }
        return res.toString();
    }
}
