package Leetcode;
/*
    Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

    Example 1:

    Input:
    [
      [1,1,1],
      [1,0,1],
      [1,1,1]
    ]
    Output:
    [
      [1,0,1],
      [0,0,0],
      [1,0,1]
    ]
    Example 2:

    Input:
    [
      [0,1,2,0],
      [3,4,5,2],
      [1,3,1,5]
    ]
    Output:
    [
      [0,0,0,0],
      [0,4,5,0],
      [0,3,1,0]
    ]
    Follow up:

    A straight forward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?
 */
public class Medium_SetMatrixZeros_73 {
    // 思路：非常笨的做法，先把matrix做个备份，再检查copy中每个元素是否为0
    // 如果是0set原矩阵所在行和列为0
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return;
        }
        int[][] copy = new int[matrix.length][];
        for(int i = 0; i < matrix.length; i++){
            copy[i] = matrix[i].clone();
            // System.out.println(Arrays.toString(copy[i]));
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(copy[i][j] == 0){
                    setZeros(matrix, i, j);
                }
            }
        }
    }

    private void setZeros(int[][] matrix, int row, int col){
        if(row == 0){
            for(int i = 0; i < matrix.length; i++){
                if(matrix[i][col] != 0){
                    matrix[i][col] = 0;
                }
            }
        } else if(row == matrix.length - 1){
            for(int i = matrix.length - 1; i >= 0; i--){
                if(matrix[i][col] != 0){
                    matrix[i][col] = 0;
                }
            }
        } else {
            for(int i = 0; i < row; i++){
                if(matrix[i][col] != 0){
                    matrix[i][col] = 0;
                }
            }
            for(int i = matrix.length - 1; i > row; i--){
                if(matrix[i][col] != 0){
                    matrix[i][col] = 0;
                }
            }
        }

        if(col == 0){
            for(int i = 0; i < matrix[row].length; i++){
                if(matrix[row][i] != 0){
                    matrix[row][i] = 0;
                }
            }
        } else if(col == matrix[row].length - 1){
            for(int i = matrix[row].length - 1; i >= 0; i--){
                if(matrix[row][i] != 0){
                    matrix[row][i] = 0;
                }
            }
        } else {
            for(int i = 0; i < col; i++){
                if(matrix[row][i] != 0){
                    matrix[row][i] = 0;
                }
            }
            for(int i = matrix[row].length - 1; i > col; i--){
                if(matrix[row][i] != 0){
                    matrix[row][i] = 0;
                }
            }
        }
    }
}
