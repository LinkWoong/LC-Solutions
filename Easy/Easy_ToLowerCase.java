package Leetcode;
/*
    Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

    Example 1:

    Input: "Hello"
    Output: "hello"
    Example 2:

    Input: "here"
    Output: "here"
    Example 3:

    Input: "LOVELY"
    Output: "lovely"
 */

public class Easy_ToLowerCase {
    public static void main(String[] args){
        String s = "Hello";

        // String result = toLowerCase(s);
        // System.out.println(result);

        String result = toLowerCase_v2(s);
        System.out.println(result);
    }

    // 利用自带的的toLowerCase()
    private static String toLowerCase(String str){
        return str.toLowerCase();
    }

    // Runtime: 0 ms, faster than 100.00% of Java online submissions
    private static String toLowerCase_v2(String str){
        char[] result = new char[str.length()];

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c >= 65 && c <= 90){
                result[i] = (char) (c + 32);
            }
            else{
                result[i] = c;
            }
        }
        return new String(result);
    }

    private static String toLowerCase_v3(String str){
        return null;
    }
}
