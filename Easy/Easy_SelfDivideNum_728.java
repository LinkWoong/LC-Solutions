package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    A self-dividing number is a number that is divisible by every digit it contains.

    For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

    Also, a self-dividing number is not allowed to contain the digit zero.

    Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

    Example 1:

    Input:
    left = 1, right = 22
    Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
    Note:

    The boundaries of each input argument are 1 <= left <= right <= 10000.
 */
public class Easy_SelfDivideNum_728 {
    public static void main(String[] args){
        List<Integer> arr = selfDividingNumbers(1, 22);
        System.out.println(arr);
        // System.out.println(21 % 2);

    }
    
    // Runtime: 7 ms, faster than 35.61% of Java online submissions
    public static List<Integer> selfDividingNumbers(int left, int right){
        int mod = 0;
        int temp = 0;
        int status = 0;

        if(right > 10){
            List<Integer> list = new ArrayList<>();
            for(int i = left; i<= right; i++){
                temp = i;
                status = 0;
                while(temp > 0){
                    mod = temp % 10;
                    if(mod == 0){
                        status++;
                        break;
                    }
                    status += i % mod;
                    temp = temp / 10;
                }
                if(status == 0){
                    list.add(i);
                }
            }
            return list;
        }
        else{
            List<Integer> list = new ArrayList<>();
            for(int i = left; i<= right; i++){
                list.add(i);
            }
            return list;
        }

    }
}
