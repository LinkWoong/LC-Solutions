package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
    Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".

    Example 1:

    Input: ["flower","flow","flight"]
    Output: "fl"

    Example 2:

    Input: ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.

    Note:

    All given inputs are in lowercase letters a-z.
 */
public class Easy_LongestCommonPrefix_14 {
    // 思路：必须要从length最小的算起，所以先写一个comparator，根据每个str的长度sort the array to be ascending。
    // 再从第一个开始，对每个字符遍历。注意这里字符出现的index必须一致，否则不能算作common character。
    // 如果第i个字符匹配不上，后面也就不匹了，直接break掉，返回StringBuilder.toString()
    // 最后再处理两个Corner case就行了
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        else if(strs.length == 1)
            return strs[0];
        Comparator<String> cmp = Comparator.comparingInt(String::length);
        Arrays.sort(strs, cmp);
        StringBuilder res = new StringBuilder();
        boolean contains = false;

        for(int i = 0; i < strs[0].length(); i++){
            for(int j = 1; j < strs.length; j++){
                if(strs[j].charAt(i) == strs[0].charAt(i))
                    contains = true;
                else{
                    contains = false;
                    break;
                }
            }
            if(contains)
                res.append(strs[0].charAt(i));
            else
                break;
        }
        return res.toString();
    }
}
