package Leetcode;

import java.util.Stack;
/*
    Given two sequences pushed and popped with distinct values,
    return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.

    Example 1:

    Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
    Output: true
    Explanation: We might do the following sequence:
    push(1), push(2), push(3), push(4), pop() -> 4,
    push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
    Example 2:

    Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
    Output: false
    Explanation: 1 cannot be popped before 2.


    Note:

    0 <= pushed.length == popped.length <= 1000
    0 <= pushed[i], popped[i] < 1000
    pushed is a permutation of popped.
    pushed and popped have distinct values.

 */
public class Medium_ValidStackSequence_946 {
    // 思路：用一个stack保存pushed数组中的元素，同时用一个指针对popped数组进行扫描
    // 每push一个元素，如果栈顶的元素和指针所指的popped数组元素相等，就pop同时指针移动一位
    // 直到栈为空或者栈顶元素不等于指针所指的元素
    // 如果栈为空则说明全部匹配上，否则返回false
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed == null || pushed.length == 0 || popped == null || popped.length == 0){
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int p = 0;
        for(int i = 0; i < pushed.length; i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty() && stack.peek() == popped[p]){
                stack.pop();
                p++;
            }
        }
        return stack.isEmpty();
    }
}
