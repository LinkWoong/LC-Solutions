package Leetcode;

import java.util.HashMap;
import java.util.Map;
/*
    Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

    Example:

    Input: S = "ADOBECODEBANC", T = "ABC"
    Output: "BANC"
    Note:

    If there is no such window in S that covers all characters in T, return the empty string "".
    If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class Hard_MinimumWindowSubstr_76 {
    // 思路：双指针+HashMap
    // 首先把mask字符串的每个character和其num of appearance放到HashMap里
    // 再用双指针start, end从target string头部开始扫描，如果HashMap存在c就--，并且如果c对应的value为0说明mask中的c已经匹配完毕
    // count的意义在于控制双指针，当end匹配完mask的全部字符，count为0，这时开始移动start
    // start的操作和end相反，如果HashMap存在c就++，如果value > 0 再count++。head是用来存想要的start index，len是符合条件的str长度
    // 最后end会移动到s的最末端，head为起始index，len为目标str的长度，直接返回substring即可
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || s.length() < t.length()){
            return "";
        }
        StringBuilder res = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0, head = 0;
        int count = map.size();
        int len = Integer.MAX_VALUE;

        while(end < s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0){
                    count--;
                }
            }
            end++;

            while(count == 0){
                c = s.charAt(start);
                if(map.containsKey(c)){
                    map.put(c, map.get(c) + 1);
                    if(map.get(c) > 0){
                        count++;
                    }
                }
                if(end - start < len){
                    len = end - start;
                    head = start;
                }
                start++;
            }
        }
        if(len == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(head, head + len);
    }
}
