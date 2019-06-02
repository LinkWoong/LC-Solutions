package Leetcode;

import java.util.Stack;

/*
    Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
    We repeatedly make duplicate removals on S until we no longer can.
    Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.

    Example 1:

    Input: "abbaca"
    Output: "ca"
    Explanation:
    For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal,
    and this is the only possible move.
    The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

    Note:

    1 <= S.length <= 20000
    S consists only of English lowercase letters.
 */
public class Easy_RemoveAllAdjacentDupsInString_1047 {
    // 思路：要求删除相邻重复的character，重点是对删除后的字符串再次进行判断，which means要求储存
    // 首先想到stack，当非空并且栈顶元素和current character一样就出栈，否则就进栈
    // 最后栈内元素为结果
    public String removeDuplicates(String s){
        if(s == null || s.length() == 0){
            return "";
        }
        int start = 0;
        char[] stack = new char[s.length()];
        for(int i = 0; i < s.length(); i++){
            if(start > 0 && stack[start - 1] == s.charAt(i)){
                start--;
            } else {
                stack[start] = s.charAt(i);
                start++;
            }
        }
        return new String(stack, 0, start);
    }
    public String removeDuplicates_v2(String S) {
        if(S == null || S.length() == 0){
            return "";
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < S.length(); i++){
            if(!stack.isEmpty() && stack.peek() == S.charAt(i)){
                stack.pop();
            } else{
                stack.push(S.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
}
