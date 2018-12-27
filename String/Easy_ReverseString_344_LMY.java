package LeetCode;

public class Easy_ReverseString_344_LMY {
    public String reverseString(String s) {
        if(s.length() < 1)
            return "";
        StringBuilder res = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--){
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}
