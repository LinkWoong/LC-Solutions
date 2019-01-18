package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Find the minimum length word from a given dictionary words,
    which has all the letters from the string licensePlate. Such a word is said to complete the given string licensePlate

    Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.
    It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.

    The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.

    Example 1:
    Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
    Output: "steps"
    Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
    Note that the answer is not "step", because the letter "s" must occur in the word twice.
    Also note that we ignored case for the purposes of comparing whether a letter exists in the word.

    Example 2:
    Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
    Output: "pest"
    Explanation: There are 3 smallest length words that contains the letters "s".
    We return the one that occurred first.

    Note:
    licensePlate will be a string with length in range [1, 7].
    licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
    words will have a length in the range [10, 1000].
    Every words[i] will consist of lowercase letters, and have length in range [1, 15].
 */
public class Easy_ShortestCompleteWord_748 {
    public static void main(String[] args){
        String plate = "H504939";
        String[] words = {"bit","someone","those","line","option","else","play","fine","computer","half"};
        String res = shortestCompletingWord(plate, words);
        System.out.println(res);
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        String res = licensePlate.replaceAll("[0-9\\s]+", "").toLowerCase();
        List<String> list = new ArrayList<>();
        for(String str: words){
            String temp = str;
            int count = 0;
            for(char c: res.toCharArray()){
                if(temp.indexOf(c) == -1){
                    break;
                }
                else{
                    temp = temp.substring(0, temp.indexOf(c)) + temp.substring(temp.indexOf(c) + 1);
                    count++;
                }
            }
            if(count == res.length()){
                list.add(str);
            }
        }
        if(list.size() == 0)
            return null;

        int result = list.get(0).length();
        int key = 0;
        for(int i = 0; i < list.size(); i++){
            int length = list.get(i).length();
            if(result >= length) {
                result = length;
                key = i;
            }
        }
        System.out.println(list);
        return list.get(key);
    }
}
