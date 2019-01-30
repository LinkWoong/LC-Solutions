package Leetcode;

import java.util.Arrays;

/*
    Given two strings s and t , write a function to determine if t is an anagram of s.

    Example 1:

    Input: s = "anagram", t = "nagaram"
    Output: true
    Example 2:

    Input: s = "rat", t = "car"
    Output: false
    Note:
    You may assume the string contains only lowercase alphabets.

    Follow up:
    What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class Easy_ValidAnagram_242 {
    // 思路：只需将s，t中每个char映射到int数组中，再根据排序后的结果来比较是否符合anagram条件
    public boolean isAnagram(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if(sl != tl)
            return false;
        int[] s_map = new int[sl];
        int[] t_map = new int[tl];
        for(int i = 0; i < s.length(); i++)
            s_map[i] = s.charAt(i) - 'a';
        for(int i = 0; i < t.length(); i++)
            t_map[i] = t.charAt(i) - 'a';
        Arrays.sort(s_map);
        Arrays.sort(t_map);

        for(int i = 0; i < s_map.length; i++){
            if(s_map[i] != t_map[i])
                return false;
        }
        return true;
    }
}
