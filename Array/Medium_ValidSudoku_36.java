package Leetcode;

import java.util.*;

/*
    Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

    A partially filled sudoku which is valid.

    The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

    Example 1:

    Input:
    [
      ['5','3','.','.','7','.','.','.','.'],
      ['6','.','.','1','9','5','.','.','.'],
      ['.','9','8','.','.','.','.','6','.'],
      ['8','.','.','.','6','.','.','.','3'],
      ['4','.','.','8','.','3','.','.','1'],
      ['7','.','.','.','2','.','.','.','6'],
      ['.','6','.','.','.','.','2','8','.'],
      ['.','.','.','4','1','9','.','.','5'],
      ['.','.','.','.','8','.','.','7','9']
    ]
    Output: true

    Example 2:

    Input:
    [
      ['8','3','.','.','7','.','.','.','.'],
      ['6','.','.','1','9','5','.','.','.'],
      ['.','9','8','.','.','.','.','6','.'],
      ['8','.','.','.','6','.','.','.','3'],
      ['4','.','.','8','.','3','.','.','1'],
      ['7','.','.','.','2','.','.','.','6'],
      ['.','6','.','.','.','.','2','8','.'],
      ['.','.','.','4','1','9','.','.','5'],
      ['.','.','.','.','8','.','.','7','9']
    ]
    Output: false
    Explanation: Same as Example 1, except with the 5 in the top left corner being
        modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
    Note:

    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.
    The given board contain only digits 1-9 and the character '.'.
    The given board size is always 9x9.
    [[".",".",".",".","5",".",".","1","."],
    [".","4",".","3",".",".",".",".","."],
    [".",".",".",".",".","3",".",".","1"],
    ["8",".",".",".",".",".",".","2","."],
    [".",".","2",".","7",".",".",".","."],
    [".","1","5",".",".",".",".",".","."],
    [".",".",".",".",".","2",".",".","."],
    [".","2",".","9",".",".",".",".","."],
    [".",".","4",".",".",".",".",".","."]]

 */
public class Medium_ValidSudoku_36 {

    // 思路：按照三条规则一个个来：
    // 前两个很好做，只需要写一个containsDuplicate然后对每行/列调用即可
    // 第三个涉及到了slicing，目的是让这个3x3的sub-box不含重复元素
    // 一种想法是就直接搞出3x3的sub-box，但这个有点绕，需要计算好row和col的提前量
    // 第二种想法是flatten成1维数组，再调用containsDuplicate函数
    // 代码很啰嗦
    // Runtime: 21 ms, faster than 33.57% of Java online submissions for Valid Sudoku.
    public boolean isValidSudoku(char[][] nums) {
        return rowChecker(nums) && colChecker(nums) && blockChecker(nums);
    }

    private static boolean rowChecker(char[][] nums){
        boolean unique = true;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[i].length; j++){
                if(containsDup(nums[i])){
                    unique = false;
                    break;
                }
            }
        }
        return unique;
    }

    private static boolean colChecker(char[][] nums){
        boolean unique = true;
        for(int i = 0; i < nums[0].length; i++){
            char[] temp = new char[nums[0].length];
            for(int j = 0; j < nums.length; j++){
                temp[j] = nums[j][i];
            }
            if(containsDup(temp)){
                unique = false;
            }
        }
        return unique;
    }

    private static boolean blockChecker(char[][] nums){
        int size = nums.length / 3 * (nums[0].length / 3);
        boolean unique = true;
        for(int c = 0; c < size; c++){
            char[][] temp = new char[3][3];
            char[] flatten = new char[9];
            int start_x = (3 * (c / 3)) % nums.length;
            int start_y = (3 * c) % nums[0].length;
            if(start_y + 3 > nums[0].length)
                start_y = 0;

            for(int row = 0; row < 3; row++){
                for(int col = 0; col < 3; col++){
                    temp[row][col] = nums[start_x + row][start_y + col];
                    flatten[row*3 + col] = nums[start_x + row][start_y + col];
                }
            }
            if(containsDup(flatten))
                unique = false;
        }
        return unique;
    }

    private static boolean containsDup(char[] nums){
        Set<Character> set = new HashSet<>();
        for(char c: nums){
            if(c != '.' && !set.add(c)){
                return true;
            }
            set.add(c);
        }
        return false;
    }
}
