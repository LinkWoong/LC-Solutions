package Leetcode;

import java.util.*;
/*
    You have a list of words and a pattern, and you want to know which words in words matches the pattern.
    A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
    (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)

    Return a list of the words in words that match the given pattern.

    You may return the answer in any order.
    Example 1:

    Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
    Output: ["mee","aqq"]
    Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
    "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
    since a and b map to the same letter.

    Note:

    1 <= words.length <= 50
    1 <= pattern.length = words[i].length <= 20
 */

public class Medium_FindPattern_890 {

    public static void main(String[] args){
        String[] words = {"badc","abab","dddd","dede","yyxx"};
        String pattern = "baba";

        List<String> res = findAndReplacePattern(words, pattern);
        System.out.println(res);

        // inkedHashMap<Character, Integer> yyxx = helper("yyxx");
        // System.out.println(yyxx);
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern){
        // find the pattern
        int[] hm_pattern = helper(pattern);
        List<String> res = new ArrayList<>();
        for(String word: words){
            int[] temp = helper(word);
            if(Arrays.equals(hm_pattern, temp)){
                res.add(word);
            }
        }
        return res;
    }

    private static int[] helper(String word){
        HashMap<Character, Integer> hm = new HashMap<>();
        int n = word.length();
        int[] res = new int[n];

        for(int i = 0; i < n; i++){
            hm.putIfAbsent(word.charAt(i), hm.size());
            res[i] = hm.get(word.charAt(i));
        }
        return res;
    }

    /*
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        // find the pattern
        LinkedHashMap<Character, Integer> hm_pattern = helper(pattern);
        Queue<Integer> queue_pattern = new LinkedList<>(hm_pattern.values());
        System.out.println("The pattern is " + queue_pattern);
        List<String> res = new ArrayList<>();

        for(String str : words){
            LinkedHashMap<Character, Integer> temp = helper(str);
            Queue<Integer> temp_pattern = new LinkedList<>(temp.values());
            if(Arrays.equals(queue_pattern.toArray(), temp_pattern.toArray())){
                res.add(str);
            }
        }
        return res;
    }

    private static LinkedHashMap<Character, Integer> helper(String word){
        LinkedHashMap<Character, Integer> hm = new LinkedHashMap<>();
        Integer value = 0;
        for(char c : word.toCharArray()){
            if(!hm.containsKey(c)){
                value = 1;
                hm.put(c, value);
            }
            else{
                value = hm.get(c);
                if(value == null)
                    value = 0;
                value++;
                hm.put(c, value);
            }
        }
        return hm;
    }
    */
}
