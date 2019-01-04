package Leetcode;

import java.util.LinkedList;
import java.util.List;

/*
    Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
    Return a list of all possible strings we could create.

    Examples:
    Input: S = "a1b2"
    Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

    Input: S = "3z4"
    Output: ["3z4", "3Z4"]

    Input: S = "12345"
    Output: ["12345"]
 */
public class Easy_LettercasePermutation_784 {

    //DFS深度优先搜索即可解决
    public List<String> letterCasePermutation(String S) {
        if(S == null){
            return new LinkedList<>();
        }
        List<String> res = new LinkedList<>();
        helper(S.toCharArray(), res, 0);

        return res;
    }

    public void helper(char[] arr, List<String> res, int pos){
        if(pos == arr.length){
            res.add(new String(arr));
            return;
        }

        if(arr[pos] >= '0' && arr[pos] <= '9'){
            helper(arr, res, pos + 1);
            return;
        }

        arr[pos] = Character.toLowerCase(arr[pos]);
        helper(arr, res, pos + 1);

        arr[pos] = Character.toUpperCase(arr[pos]);
        helper(arr, res, pos + 1);
    }
}
