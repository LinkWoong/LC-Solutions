package Leetcode;

import java.util.Arrays;

/*
    A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

    We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

    The rules of Goat Latin are as follows:

    If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
    For example, the word 'apple' becomes 'applema'.

    If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
    For example, the word "goat" becomes "oatgma".

    Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
    For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
    Return the final sentence representing the conversion from S to Goat Latin.

    Example 1:

    Input: "I speak Goat Latin"
    Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
    Example 2:

    Input: "The quick brown fox jumped over the lazy dog"
    Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 */
public class Easy_GoatLatin_824 {

    // 思路：nothing special, 就是跟着条件一步步操作字符串即可
    public String toGoatLatin(String S) {
        StringBuilder res = new StringBuilder();
        int count = 1;
        for(String str: S.split("\\s+")){
            char head = str.charAt(0);
            if(head == 'a' || head == 'e' || head == 'i' || head == 'o' || head == 'u' ||
                    head == 'A' || head == 'E' || head == 'I' || head == 'O' || head == 'U'){
                res.append(str);
                res.append("ma");

            }
            else{
                res.append(str, 1, str.length());
                res.append(head);
                res.append("ma");
            }
            for(int i = 0; i < count; i++)
                res.append("a");

            if(count != S.split("\\s+").length)
                res.append(" ");
            count++;
        }
        return res.toString();
    }
}
