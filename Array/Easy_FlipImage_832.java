package Leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
    Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

    To flip an image horizontally means that each row of the image is reversed.
    For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

    To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
    For example, inverting [0, 1, 1] results in [1, 0, 0].

    Example 1:

    Input: [[1,1,0],[1,0,1],[0,0,0]]
    Output: [[1,0,0],[0,1,0],[1,1,1]]
    Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
    Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
    Example 2:

    Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
    Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
    Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
    Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
    Notes:

    1 <= A.length = A[0].length <= 20
    0 <= A[i][j] <= 1
 */
public class Easy_FlipImage_832 {
    public static void main(String[] args){
        int[][] test = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] test2 = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        int[][] result = flipAndInvertImage(test2);
        System.out.println(Arrays.toString(result[1]));
    }

    // 基本数组操作, time O(n^2)
    // Runtime: 5 ms, faster than 52.10% of Java online submissions
    private static int[][] flipAndInvertImage(int[][] arr){
        for(int i = 0; i <= arr.length - 1; i++){
            for(int j = 0; j <= arr[i].length/2 - 1; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[i][arr[i].length - 1 - j];
                arr[i][arr[i].length - 1 - j] = temp;
            }
        }

        for(int i = 0; i <= arr.length - 1; i++){
            for(int j = 0; j <= arr[i].length - 1; j++){
                if(arr[i][j] == 1){
                    arr[i][j] = 0;
                }
                else{
                    arr[i][j] = 1;
                }
            }
        }

        return arr;
    }
}
