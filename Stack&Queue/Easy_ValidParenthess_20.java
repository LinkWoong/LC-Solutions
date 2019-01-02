package Leetcode;

import java.util.Stack;

/*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Note that an empty string is also considered valid.

    Example 1:

    Input: "()"
    Output: true
    Example 2:

    Input: "()[]{}"
    Output: true
    Example 3:

    Input: "(]"
    Output: false
    Example 4:

    Input: "([)]"
    Output: false
    Example 5:

    Input: "{[]}"
    Output: true
 */
public class Easy_ValidParenthess_20 {
    public static void main(String[] args){
        // System.out.println("Ass");
        boolean result = isValid("([]            )");
        System.out.println(result);
    }
    // Runtime: 9 ms, faster than 19.40% of Java online submissions
    // 用栈来储存一半，再遍历匹配右半部分。匹配到了就出栈
    public static boolean isValid(String s){
        if(s.isEmpty())
            return true;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '{' || cur == '[' || cur == '('){
                st.push(cur);
            }

            if(cur == '}' || cur == ']' || cur == ')'){
                if(st.isEmpty()){
                    return false;
                }
                if(st.peek() == '{' && cur == '}' || st.peek() == '[' && cur == ']' || st.peek() == '(' && cur == ')'){
                    st.pop();
                }
                else
                    return false;
            }
        }
        return st.isEmpty();
    }

    // Runtime: 1 ms, indexing
    public static boolean isValid_v2(String s){
        char[] stack = new char[s.length() + 1];
        int top = 1;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack[top++] = c;
            } else if (c == ')' && stack[--top] != '(') {
                return false;
            } else if (c == ']' && stack[--top] != '[') {
                return false;
            } else if (c == '}' && stack[--top] != '{') {
                return false;
            }
        }
        return top == 1;
    }
}
