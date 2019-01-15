package Leetcode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
    S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
    S was sorted in some custom order previously.
    We want to permute the characters of T so that they match the order that S was sorted.
    More specifically, if x occurs before y in S, then x should occur before y in the returned string.
    Return any permutation of T (as a string) that satisfies this property.

    Example :
    Input:
    S = "cba"
    T = "abcd"
    Output: "cbad"
    Explanation:
    "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
    Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.

    Note:

    S has length at most 26, and no character is repeated in S.
    T has length at most 200.
    S and T consist of lowercase letters only.
 */
public class Medium_CustomSortString_791 {

    public static void main(String[] args){
        String S = "kqep";
        String T = "pekeq";
        String res = customSortString(S, T); // kqeep
        System.out.println(res);
    }

    // 思路：用HashMap存储T中所有元素及其个数，再在S中寻找匹配到的元素，append后删除。最后将S中没有的元素append
    public static String customSortString(String S, String T) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char t: T.toCharArray()){
            map.put(t, map.getOrDefault(t,0) + 1);
        }

        StringBuilder res = new StringBuilder();
        for(char s: S.toCharArray()){
            int freq = map.getOrDefault(s,0);
            for(int i = 0; i < freq; i++){
                res.append(s);
            }
            map.remove(s);
        }

        for(char t: map.keySet()){
            int freq = map.getOrDefault(t,0);
            for(int i =0 ; i < freq; i++){
                res.append(t);
            }
        }
        return res.toString();
    }
}
