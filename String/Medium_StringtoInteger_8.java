package Leetcode;
/*
    Implement atoi which converts a string to an integer.
    The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
    Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
    and interprets them as a numerical value.

    The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
    If the first sequence of non-whitespace characters in str is not a valid integral number,
    or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
    If no valid conversion could be performed, a zero value is returned.

    Note:

    Only the space character ' ' is considered as whitespace character.
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
    If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.

    Example 1:

    Input: "42"
    Output: 42

    Example 2:

    Input: "   -42"
    Output: -42
    Explanation: The first non-whitespace character is '-', which is the minus sign.
                 Then take as many numerical digits as possible, which gets 42.
    Example 3:

    Input: "4193 with words"
    Output: 4193
    Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.

    Example 4:

    Input: "words and 987"
    Output: 0
    Explanation: The first non-whitespace character is 'w', which is not a numerical
                 digit or a +/- sign. Therefore no valid conversion could be performed.

    Example 5:

    Input: "-91283472332"
    Output: -2147483648
    Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
                 Thefore INT_MIN (−231) is returned.
 */
public class Medium_StringtoInteger_8 {

    // 思路：先将空格去掉并把数字的符号搞到
    // 从头开始每次计算char[i]到'0'的距离，再加到num*10中
    // 如果num在*10之前已经达到了214748364并且计算的digit>7，which means num*10之后将会overflow
    // 再根据符号返回2^31 or -2^31-1
    public int myAtoi(String str){
        int i = 0;
        str = str.trim();
        char[] c = str.toCharArray();

        int sign = 1;
        if (i < c.length && (c[i] == '-' || c[i] == '+')) {
            if (c[i] == '-') {
                sign = -1;
            }
            i++;
        }

        int num = 0;
        int bound = Integer.MAX_VALUE / 10;
        while (i < c.length && c[i] >= '0' && c[i] <= '9') {
            int digit = c[i] - '0';
            if (num > bound || (num == bound && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        return sign * num;
    }

    public static int myAtoi_v2(String str) {
        str = str.trim();
        if(str.length() == 0 || !Character.isDigit(str.charAt(0)) && str.charAt(0) != '-' && str.charAt(0) != '+')
            return 0;
        str = str.replaceAll("[^0-9-\\.]+", "");
        str = str.replaceAll("\\+", "");
        str = str.split("\\.")[0];
        if(str == null || str.length() == 0){
            return 0;
        }

        System.out.println(str);

        int result = 0;
        char[] arr = str.toCharArray();
        int multiplier = 1;
        int start = arr.length - 1;

        for(int i = 0; i < arr.length; i++){
            if(str.charAt(i) == '-'){
                multiplier = -1;
                start--;
                continue;
            }
            result += Character.getNumericValue(arr[i]) * Math.pow(10, start) * multiplier;
            start--;
            if(result >= Integer.MAX_VALUE || result <= Integer.MIN_VALUE){
                return result >= Integer.MAX_VALUE ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return result;
    }
}
