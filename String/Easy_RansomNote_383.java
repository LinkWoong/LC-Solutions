package Leetcode;
/*
    Given an arbitrary ransom note string and another string containing letters from all the magazines,
    write a function that will return true if the ransom note can be constructed from the magazines ;
    otherwise, it will return false.

    Each letter in the magazine string can only be used once in your ransom note.

    Note:
    You may assume that both strings contain only lowercase letters.

    canConstruct("a", "b") -> false
    canConstruct("aa", "ab") -> false
    canConstruct("aa", "aab") -> true
 */
public class Easy_RansomNote_383 {
    // 思路：又用到了老方法映射，给ransomNote和magazine分别创造一个映射，再比较每个char的相对位置
    // 如果ransomNote对应的pos > magazine，返回false
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || ransomNote.length() == 0){
            return true;
        }
        int[] notemap = new int[26];
        int[] magmap = new int[26];
        for(int i = 0; i < ransomNote.length(); i++){
            notemap[ransomNote.charAt(i) - 'a']++;
        }
        for(int i = 0; i < magazine.length(); i++){
            magmap[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0; i < ransomNote.length(); i++){
            if(notemap[ransomNote.charAt(i) - 'a'] > magmap[ransomNote.charAt(i) - 'a']){
                return false;
            }
        }
        return true;
    }
}
