package Leetcode;

import java.util.*;

/*
    Given an array of strings, group anagrams together.

    Example:

    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Output:
    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]
    Note:

    All inputs will be in lowercase.
    The order of your output does not matter.
 */
public class Medium_GroupAnagrams_49 {
    // 思路：为每个str做一个mapping找到其anagram，再把标准化后（sort）的anagram放到HashMap中去
    // key为anagram，value为属于这个anagram的String list。
    // 最后把所有list加到List<List<String>>中即可
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }

        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] cmap = s.toCharArray();
            Arrays.sort(cmap);
            String str = String.valueOf(cmap);
            if(!map.containsKey(str)){
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(s);
        }
        for(List<String> list: map.values()){
            res.add(list);
        }
        return res;
    }
}
