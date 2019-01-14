package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    A string S of lowercase letters is given.
    We want to partition this string into as many parts as possible so that each letter appears in at most one part,
    and return a list of integers representing the size of these parts.

    Example 1:
    Input: S = "ababcbacadefegdehijhklij"
    Output: [9,7,8]
    Explanation:
    The partition is "ababcbaca", "defegde", "hijhklij".
    This is a partition so that each letter appears in at most one part.
    A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
    Note:

    S will have length in range [1, 500].
    S will consist of lowercase letters ('a' to 'z') only.
 */
public class Medium_PartitionLabels_763 {

    // 思路：用cnt[S.charAt(i) - 'a']获得每个char的mapping，再利用i来得到每个字母最后出现的index
    // 再遍历一次，用双指针last, start记录是否和之前的映射匹配，匹配上了就add字符串的长度到List<Integer> res里，
    // 再更新start为last+1，或者删除之前匹配的字符串start还是为0
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] cnt = new int[26];
        for(int i = 0; i < S.length(); i++)
            cnt[S.charAt(i) - 'a'] = i;

        int last = 0;
        int start = 0;

        for(int i = 0;i < S.length(); i++){
            last = Math.max(last, cnt[S.charAt(i) - 'a']);
            if(last == i){
                res.add(last - start + 1);
                start = last + 1;
            }
        }
        return res;
    }
}
