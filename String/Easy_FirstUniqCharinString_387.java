package Leetcode;
import java.util.*;

/*
    Given a string, find the first non-repeating character in it and return it's index.
    If it doesn't exist, return -1.

    Examples:

    s = "leetcode"
    return 0.

    s = "loveleetcode",
    return 2.
    Note: You may assume the string contain only lowercase letters.
*/
public class Easy_FirstUniqCharinString_387 {
    // 思路：先把每个char及其appearance放到LinkedHashMap中去，再对keySet进行遍历
    // 访问到value为1的键跳出，返回该键在字符串中F的index
    public int firstUniqChar(String s) {
        if(s.length() == 0)
            return -1;
        Map<Character, Integer> hs = new LinkedHashMap<>();
        for(char c: s.toCharArray()){
            if(!hs.containsKey(c))
                hs.put(c, 1);
            else{
                hs.put(c, hs.getOrDefault(c, 0)+1);
            }
        }
        Character res = null;
        for(Character c: hs.keySet()){
            if(hs.get(c) == 1){
                res = c;
                break;
            }
        }
        return res == null ? -1 : s.indexOf(res);
    }
}
