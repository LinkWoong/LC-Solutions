package Leetcode;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
    Given a string S and a character C,
    return an array of integers representing the shortest distance from the character C in the string.

    Example 1:

    Input: S = "loveleetcode", C = 'e'
    Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]


    Note:

    S string length is in [1, 10000].
    C is a single character, and guaranteed to be in string S.
    All letters in S and C are lowercase.
 */
public class Easy_DistanceToChar_821 {
    public static void main(String[] args){
        String s = "loveleetcode";
        char c = 'e';
        int[] result = shortestToChar(s, c);
        System.out.println(Arrays.toString(result));
    }

    public static int[] shortestToChar(String s, char c){
        ArrayList<Integer> list = new ArrayList<>();
        int[] res = new int[s.length()];

        for(int index = s.indexOf(c); index >= 0; index = s.indexOf(c, index + 1)){
            list.add(index);
        }

        for(int i = 0; i < s.length(); i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for (Integer aList : list) {
                temp.add(Math.abs(i - aList));
            }
            res[i] = Collections.min(temp);
        }
        return res;
    }

    // 双向搜索
    // Runtime: 6 ms, faster than 59.49% of Java online submissions
    public static int[] shortestToChar_v2(String S, char C){
        int[] res = new int[S.length()];

        if(S == null || S.length() == 0) return res;
        char[] c = S.toCharArray();

        int prev = -1;
        for(int i = 0; i < c.length; i++) {
            if(c[i] == C) {
                prev = i;
            }
            res[i] = prev == -1 ? Integer.MAX_VALUE : i - prev;
        }

        prev = Integer.MAX_VALUE;
        for(int i = c.length-1; i >= 0; i--) {
            if(c[i] == C) {
                prev = i;
            }
            res[i] = Math.min(res[i], prev - i);
        }
        return res;

    }
}
