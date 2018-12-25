package Leetcode;

import java.util.HashSet;

/*
    You're given strings J representing the types of stones that are jewels,
    and S representing the stones you have.  Each character in S is a type of stone you have.
    You want to know how many of the stones you have are also jewels.

    The letters in J are guaranteed distinct, and all characters in J and S are letters.
    Letters are case sensitive, so "a" is considered a different type of stone from "A".

    Example 1:

    Input: J = "aA", S = "aAAbbbb"
    Output: 3

    Example 2:

    Input: J = "z", S = "ZZ"
    Output: 0
    Note:

    S and J will consist of letters and have length at most 50.
    The characters in J are distinct.
*/
public class Easy_JewelsAndStones {
    public static void main(String[] args){
        String J = "wch";
        String S = "abcAssDDCCChcHH";
        int result = 0;

        result = numJewelsInStones_v1(J, S);
        System.out.println(result);

        result = numJewelsInStones_v2(J, S);
        System.out.println(result);

        result = numJewelsInStones_v3(J, S);
        System.out.println(result);
    }

    // Runtime: 14 ms, faster than 32.60%
    private static int numJewelsInStones_v1(String J, String S){
        int count = 0;

        for(char J_sub: J.toCharArray()){
            for(char S_sub: S.toCharArray()){
                if(J_sub == S_sub){
                    count++;
                }
            }
        }

        return count;
    }

    //Runtime: 10 ms, faster than 65.10% of Java online submissions
    // 利用了HashSet自动计算HashCode来考虑唯一性，很自然的想法
    private static int numJewelsInStones_v2(String J, String S){
        HashSet<Character> hs = new HashSet<>();
        for(char J_sub: J.toCharArray()){
            hs.add(J_sub);
        }

        int count = 0;
        for(char S_sub: S.toCharArray()){
            if(hs.contains(S_sub)){
                count++;
            }
        }

        return count;
    }
    
    private static int numJewelsInStones_v3(String J, String S){
        int count = 0;
        for(char S_sub: S.toCharArray()){
            if(J.indexOf(S_sub) != -1){
                count++;
            }
        }
        return count;
    }

}
