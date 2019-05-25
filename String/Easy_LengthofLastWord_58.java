package Leetcode;
/*
    Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

    If the last word does not exist, return 0.

    Note: A word is defined as a character sequence consists of non-space characters only.

    Example:

    Input: "Hello World"
    Output: 5
 */
public class Easy_LengthofLastWord_58 {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        String[] res = s.split("\\s+");
        if(res.length == 0){
            return 0;
        }
        return res[res.length - 1].length();
    }
}
