package Leetcode;
/*
    An array is monotonic if it is either monotone increasing or monotone decreasing.
    An array A is monotone increasing if for all i <= j, A[i] <= A[j].
    An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

    Return true if and only if the given array A is monotonic.
    Example 1:

    Input: [1,2,2,3]
    Output: true
    Example 2:

    Input: [6,5,4,4]
    Output: true
    Example 3:

    Input: [1,3,2]
    Output: false
    Example 4:

    Input: [1,2,4,5]
    Output: true
    Example 5:

    Input: [1,1,1]
    Output: true
    Note:

    1 <= A.length <= 50000
    -100000 <= A[i] <= 100000

 */
public class Easy_MonotonicArray_896 {

    // 思路：先考虑特殊情况，数组长度为1或2时肯定为ture；
    // 否则用两个计数器记录比较次数(A.length - 1次，所以初始化为1)和A.length的大小。
    // 如果递增up++, 递减down++。再返回次数和A.length的比较结果
    public boolean isMonotonic(int[] A) {
        if(A.length == 1 || A.length == 2)
            return true;

        int up = 1;
        int down = 1;

        for(int i = 1; i <= A.length - 1; i++){
            if(A[i] > A[i-1])
                up++;
            else if(A[i] < A[i-1])
                down++;
            else{
                up++;
                down++;
            }
        }
        return up == A.length || down == A.length;
    }
}
