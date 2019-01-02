package Leetcode;
/*
    Write a function that takes a string as input and returns the string reversed.

    Example 1:

    Input: "hello"
    Output: "olleh"
    Example 2:

    Input: "A man, a plan, a canal: Panama"
    Output: "amanaP :lanac a ,nalp a ,nam A"
 */
public class Easy_ReverseString_344 {
    public static void main(String[] args){
        String result = reverseString("A man, a plan, a canal: Panama");
        System.out.println(result);
    }

    // Runtime: 4 ms, faster than 21.62% of Java online submissions
    public static String reverseString(String s){
        char[] res = new char[s.length()];
        for(int i = 0; i < s.length(); i++){
            res[s.length() - 1 - i] = s.charAt(i);
        }
        return new String(res);
    }
}
