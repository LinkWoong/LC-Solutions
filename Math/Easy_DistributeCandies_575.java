package Leetcode;

import java.util.HashMap;
import java.util.Map;

/*
    Given an integer array with even length, where different numbers in this array represent different kinds of candies.
    Each number means one candy of the corresponding kind.
    You need to distribute these candies equally in number to brother and sister.
    Return the maximum number of kinds of candies the sister could gain.

    Example 1:
    Input: candies = [1,1,2,2,3,3]
    Output: 3
    Explanation:
    There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
    Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
    The sister has three different kinds of candies.

    Example 2:
    Input: candies = [1,1,2,3]
    Output: 2
    Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
    The sister has two different kinds of candies, the brother has only one kind of candies.
    Note:

    The length of the given array is in range [2, 10,000], and will be even.
    The number in given array is in range [-100,000, 100,000].

 */
public class Easy_DistributeCandies_575 {

    public static void main(String[] args){
        int[] candies = {1, 1, 2, 2, 3, 3};
        int res = distributeCandies(candies);
        System.out.println(res);
    }

    // 思路：先用Map将每个candy和其count作为kv pair，再返回Map大小和candy长度/2其中较小的一个
    public static int distributeCandies(int[] candies) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: candies){
            if(!map.containsKey(num))
                map.put(num, 1);
            else
                map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return Math.min(map.size(), candies.length / 2);
    }
}
