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

    // 思路2：计算s和t的每个字符在26个英文字母中的出现次数，再匹配是否相等即可
    // Runtime: 3 ms, faster than 88.41% of Java online submissions for Valid Anagram.
    public boolean isAnagram_v2(String s, String t){
        if(s.length() != t.length())
            return false;
        int[] smap = new int[26];
        int[] tmap = new int[26];
        for(int i = 0; i < s.length(); i++){
            smap[s.charAt(i) - 'a']++;
            tmap[t.charAt(i) - 'a']++;
        }

        for(int i = 0; i < smap.length; i++){
            if(smap[i] != tmap[i])
                return false;
        }
        return true;
    }
}
