package Leetcode;
/*
    Implement strStr().

    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    Example 1:

    Input: haystack = "hello", needle = "ll"
    Output: 2
    Example 2:

    Input: haystack = "aaaaa", needle = "bba"
    Output: -1
    Clarification:

    What should we return when needle is an empty string? This is a great question to ask during an interview.

    For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class Easy_ImplStrstr_28 {
    // 思路：先匹配第一个字符。匹配到以后，记录下index
    // 用两个指针分别检索haystack和needle的haystack.charAt(p1)和needle.charAt(p2), where p1和p2从index+1开始
    // 退出条件：p1碰到haystack尾部 and 两个指针所指的字符一样，如果p1没到尾部就退出了说明有不匹配字符（不连续），返回-1
    // 退出后返回第一次检索到的index
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;

        char first = needle.charAt(0);
        int max = haystack.length() - needle.length();
        for(int i = 0; i <= max; i++){
            if(haystack.charAt(i) != first){
                while(i <= max && haystack.charAt(i) != first){
                    i++;
                }
            }

            if(i <= max){
                int j = i + 1;
                int end = j + needle.length() - 1;
                for(int k = 1; j < end && haystack.charAt(j) == needle.charAt(k); k++){
                    j++;
                }
                if(j == end)
                    return i;
            }

        }
        return -1;
    }
}
