package LeetCode;

public class Easy_atoi_8_LMY {
    /*

            Implement atoi which converts a string to an integer.

    The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

    The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

    If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

    If no valid conversion could be performed, a zero value is returned.

    Note:

    Only the space character ' ' is considered as whitespace character.
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
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
    /*
    注意：
    1. null or empty string
    2. white spaces
    3. +/- sign
    4. calculate real value
    5. handle min & max
     */
    public int myAtoi(String str) {
        if(str == null||str.length() < 1)
            return 0;
        str = str.trim();

        char flag = '+';
        int i = 0;
        if(str.charAt(0) == '-'){
            flag = '-';
            i++;
        }else if(str.charAt(0) == '+'){
            i++;
        }

        double result = 0;
        while(str.length() > i && str.charAt(i) >= '0' && str.charAt(i)<='9'){
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }
        if(flag == '-')
            result = -result;

        if(result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if(result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int)result;

    }
}
