package Leetcode;
/*

    Let's call an array A a mountain if the following properties hold:

    A.length >= 3
    There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
    Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

    Example 1:

    Input: [0,1,0]
    Output: 1
    Example 2:

    Input: [0,2,1,0]
    Output: 1
    Note:

    3 <= A.length <= 10000
    0 <= A[i] <= 10^6
    A is a mountain, as defined above.
 */
public class Easy_PeakIndexArray_852 {
    public static void main(String[] args){
        int[] test = {0, 2, 1, 0, 3, 4, 5};
        int result = peakIndexInMountainArray(test);
        System.out.println(result);
    }
    
    // Runtime: 4 ms, faster than 6.92% of Java online submissions
    public static int peakIndexInMountainArray(int[] arr){
        int result = 0;
        int idx = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] >= result){
                result = arr[i];
                idx = i;
            }
        }
        return idx;
    }
}
