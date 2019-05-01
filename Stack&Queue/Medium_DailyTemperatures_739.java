package Leetcode;

import java.util.Arrays;
import java.util.Stack;

/*
    Given a list of daily temperatures T, return a list such that,
    for each day in the input, tells you how many days you would have to wait until a warmer temperature.
    If there is no future day for which this is possible, put 0 instead.

    For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73],
    your output should be [1, 1, 4, 2, 1, 1, 0, 0].

    Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class Medium_DailyTemperatures_739 {
    public static void main(String[] args){
        int[] nums = {73, 74, 75, 71, 49, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(nums)));
    }
    // 思路：遍历数组把每个下标存到栈里，当栈为非空并且栈顶元素小于目前元素时说明符合条件
    // 将栈顶的index pop出来和目前元素相减；如果pop后的栈顶还是小于目前元素，继续重复
    // 直到栈为空或者大于为止
    // Runtime: 42 ms, faster than 70.51% of Java online submissions
    public static int[] dailyTemperatures(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }

    // 思路：brute force解法，从第i个元素开始，碰到大于它的元素就记录index之差并退出本次loop
    // Runtime: 213 ms, faster than 18.01% of Java online submissions
    public static int[] dailyTemperatures_BF(int[] T) {
        if(T == null || T.length == 0){
            return null;
        }
        int[] res = new int[T.length];
        for(int i = 0; i < T.length; i++){
            for(int j = i + 1; j < T.length; j++){
                if(T[j] > T[i]){
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }
}
