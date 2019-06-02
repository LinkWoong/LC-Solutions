package Leetcode;

import java.util.ArrayList;
import java.util.List;
/*
    Given an array A of strings made only from lowercase letters,
    return a list of all characters that show up in all strings within the list (including duplicates).
    For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

    You may return the answer in any order.
    Example 1:

    Input: ["bella","label","roller"]
    Output: ["e","l","l"]
    Example 2:

    Input: ["cool","lock","cook"]
    Output: ["c","o"]


    Note:

    1 <= A.length <= 100
    1 <= A[i].length <= 100
    A[i][j] is a lowercase letter
 */
public class Easy_FindCommonCharacters_1002 {
    int[] temp = new int[26];
    public List<String> commonChars(String[] A) {
        if(A == null || A.length == 0){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        int[] map = new int[26];
        for(char c: A[0].toCharArray()){
            map[c - 'a']++;
        }

        for(int i = 1; i < A.length; i++){
            helper(A[i], map);
        }
        for(int i = 0; i < map.length; i++){
            if(map[i] != 0){
                for(int j = 0; j < map[i]; j++){
                    res.add(String.valueOf((char)(i+'a')));
                }
            }
        }

        return res;
    }

    private void helper(String s, int[] arr){
        for(char c: s.toCharArray()){
            temp[c - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(arr[i] != 0 && arr[i] != temp[i]){
                arr[i] = Math.min(arr[i], temp[i]);
            }
        }
        temp = new int[26];
    }
}
