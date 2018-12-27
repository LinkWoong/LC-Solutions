package LeetCode;

import java.util.Stack;

public class Easy_ValidParentheses_20_LMY {
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

    //accepted at 2018/12/16
    public boolean isValid(String s) {
        s = s.trim();
        if(s.length() < 1)
            return true;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='['||s.charAt(i)=='{'||s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    if(isMatch(stack.peek(),s.charAt(i))){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }

    private boolean isMatch(char first, char second){
        if(first == '{') {
            if (second == '}')
                return true;
            else
                return false;
        }else if(first == '['){
            if (second == ']')
                return true;
            else
                return false;
        }else{
            if (second == ')')
                return true;
            else
                return false;
        }
    }
}
