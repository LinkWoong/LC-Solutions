package Leetcode;

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
}
