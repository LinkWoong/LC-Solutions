package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Easy_FindAllAnagrams_438 {
    // 思路：mapping+双指针，先做好String p的映射放在int[]数组里
    // 再用双指针保持p.length()的间距
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() == 0 || p.length() > s.length()){
            return new ArrayList<>();
        }
        int[] map = new int[26];
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < p.length(); i++){
            map[p.charAt(i) - 'a']++;
        }

        int start = 0, end = p.length() - 1;
        while(end <= s.length() - 1){
            String str = s.substring(start, end + 1);
            // System.out.println(str);
            int[] temp = new int[26];
            for(int i = 0; i < str.length(); i++){
                temp[str.charAt(i) - 'a']++;
            }
            if(Arrays.equals(temp, map)){
                res.add(start);
            }
            start++;
            end++;
        }
        return res;
    }
}
