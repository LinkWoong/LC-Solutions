package Leetcode;
/*
    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

    Note: For the purpose of this problem, we define empty string as valid palindrome.

    Example 1:

    Input: "A man, a plan, a canal: Panama"
    Output: true
    Example 2:

    Input: "race a car"
    Output: false
 */
public class Easy_ValidPalindrome_125 {

    // 思路：palindrome指的是从头读和从尾读完全一样的字符串，并且只由字母和数字组成。
    // 先用regex匹配符合条件的字符串，再用双指针，一个从头另一个从尾开始扫。遇到不同返回false
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)
            return true;
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int i = 0, j = s.length() - 1;
        while(i <= s.length() - 1 || j >= 0){
            if(s.charAt(i) != s.charAt(j))
                return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }
}
