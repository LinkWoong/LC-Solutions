package Leetcode;
/*
    Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.

    Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:

    If S[i] == "I", then A[i] < A[i+1]
    If S[i] == "D", then A[i] > A[i+1]


    Example 1:

    Input: "IDID"
    Output: [0,4,1,3,2]
    Example 2:

    Input: "III"
    Output: [0,1,2,3]
    Example 3:

    Input: "DDI"
    Output: [3,2,0,1]
 */
public class Easy_DIStringMatch_942 {

    public int[] diStringMatch(String S) {
        int n = S.length();
        int left = 0;
        int right = n;
        int[] res = new int[n+1];

        for(int i = 0; i < n; ++i){
            res[i] = S.charAt(i) == 'I' ? left++ : right--;
        }
        res[n] = left;
        return res;
    }
}
