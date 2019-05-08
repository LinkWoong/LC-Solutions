package Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
/*
    Evaluate the value of an arithmetic expression in Reverse Polish Notation.

    Valid operators are +, -, *, /. Each operand may be an integer or another expression.

    Note:

    Division between two integers should truncate toward zero.
    The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
    Example 1:

    Input: ["2", "1", "+", "3", "*"]
    Output: 9
    Explanation: ((2 + 1) * 3) = 9
    Example 2:

    Input: ["4", "13", "5", "/", "+"]
    Output: 6
    Explanation: (4 + (13 / 5)) = 6
    Example 3:

    Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
    Output: 22
    Explanation:
      ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
    = ((10 * (6 / (12 * -11))) + 17) + 5
    = ((10 * (6 / -132)) + 17) + 5
    = ((10 * 0) + 17) + 5
    = (0 + 17) + 5
    = 17 + 5
    = 22
 */
public class Medium_EvaluateReversePolishNotation_150 {
    public int evalRPN(String[] tokens) {
        String[] operators = {"+", "-", "*", "/"};
        Set<String> set = new HashSet<>(Arrays.asList(operators));
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for(String s: tokens){
            if(set.contains(s) && stack.size() >= 2){
                int left = stack.pop();
                int right = stack.pop();
                switch(s){
                    case("+"): result = right + left; break;
                    case("-"): result = right - left; break;
                    case("*"): result = right * left; break;
                    case("/"): result = right / left; break;
                }
                stack.push(result);
            } else{
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.peek();
    }
}
