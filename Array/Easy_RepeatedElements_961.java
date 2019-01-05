package Leetcode;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.HashSet;

/*
    In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
    Return the element repeated N times.

    Example 1:

    Input: [1,2,3,3]
    Output: 3
    Example 2:

    Input: [2,1,2,5,3,2]
    Output: 2
    Example 3:

    Input: [5,1,5,2,5,3,5,4]
    Output: 5

    Note:

    4 <= A.length <= 10000
    0 <= A[i] < 10000
    A.length is even
 */
public class Easy_RepeatedElements_961 {
    public static void main(String[] args){
        int[] A = {5, 1, 5, 2, 5, 3, 5, 4};
        int res = repeatedNTimes(A);
        System.out.println(res);
    }

    // 非常实在的解法
    public static int repeatedNTimes(int[] A) {
        HashMap<Integer, Integer> res = new HashMap<>();
        int result = 0;
        for(int i : A){
            if(!res.containsKey(i))
                res.put(i, 1);
            else{
                int value = res.get(i);
                value++;
                res.put(i, value);
            }
        }
        for(Integer key : res.keySet()){
            if(res.get(key).equals(A.length / 2)){
                result = key;
            }
        }
        return result;
    }

    // 其实就是一个去重
    // Runtime: 8 ms, faster than 70.80% of Java online submissions
    public static int repeatedNTimes_v2(int[] A){
        HashSet<Integer> res = new HashSet<>();
        for(int i = 0; i < A.length; i++){
            if(res.contains(A[i])){
                return A[i];
            }
            else{
                res.add(A[i]);
            }
        }
        return -1;
    }
}
