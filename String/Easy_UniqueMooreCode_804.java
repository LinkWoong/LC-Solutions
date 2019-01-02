package Leetcode;

import java.util.HashSet;

/*
    Topic: String
    International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes,
    as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.

    For convenience, the full table for the 26 letters of the English alphabet is given below:

    [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.",
    "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
    Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter.
    For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-").
    We'll call such a concatenation, the transformation of a word.

    Return the number of different transformations among all words we have.

    Example:
    Input: words = ["gin", "zen", "gig", "msg"]
    Output: 2
    Explanation:
    The transformation of each word is:
    "gin" -> "--...-."
    "zen" -> "--...-."
    "gig" -> "--...--."
    "msg" -> "--...--."

    There are 2 different transformations, "--...-." and "--...--.".
    Note:

    The length of words will be at most 100.
    Each words[i] will have length in range [1, 12].
    words[i] will only consist of lowercase letters.

*/
public class Easy_UniqueMooreCode_804 {
    public static void main(String[] args){
        String[] words = {"gin", "zen", "gig", "msg"};
        int result = uniqueMorseRepresentations(words);
        System.out.println(result);
    }

    // Runtime: 5 ms, faster than 90.21% of Java online submissions
    // indexing
    private static int uniqueMorseRepresentations(String[] words){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] moorescode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.",
                "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        StringBuffer sb = new StringBuffer();

        HashSet<String> hs = new HashSet<>();
        for(String str : words){
            for(char c : str.toCharArray()){
                int index = alphabet.indexOf(c);
                sb.append(moorescode[index]);
            }
            hs.add(sb.toString());
            sb.delete(0, sb.length());
        }
        System.out.println(hs);
        return hs.size();
    }
}
