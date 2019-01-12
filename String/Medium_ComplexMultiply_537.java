package Leetcode;
/*
    Given two strings representing two complex numbers.

    You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

    Example 1:
    Input: "1+1i", "1+1i"
    Output: "0+2i"
    Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
    Example 2:
    Input: "1+-1i", "1+-1i"
    Output: "0+-2i"
    Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
    Note:

    The input strings will not have extra blank.
    The input strings will be given in the form of a+bi,
    where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.

 */
public class Medium_ComplexMultiply_537 {
    public static void main(String[] args){
        String a = "78+-76i";
        String b = "-86+72i";
        String res = complexNumberMultiply(a, b);
        System.out.println(res);
    }

    public static String complexNumberMultiply(String a, String b) {
        int a_num_index = a.indexOf('+');
        int a_i_index = a.indexOf('i');
        int a_first = Integer.parseInt(a.substring(0, a_num_index));
        int a_last = Integer.parseInt(a.substring(a_num_index + 1, a_i_index));

        int b_num_index = b.indexOf('+');
        int b_i_index = b.indexOf('i');
        int b_first = Integer.parseInt(b.substring(0, b_num_index));
        int b_last = Integer.parseInt(b.substring(b_num_index + 1, b_i_index));

        int former = a_first*b_first - a_last*b_last;
        int latter = a_first*b_last + a_last*b_first;
        System.out.println(former);
        System.out.println(latter);
        StringBuilder res = new StringBuilder();
        res.append(former);
        res.append('+');
        res.append(latter);
        res.append('i');
        return res.toString();
    }
}
