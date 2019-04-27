package Leetcode;
/*
    Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

    Note: You are not suppose to use the library's sort function for this problem.

    Example:

    Input: [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]

    Follow up:
    Could you come up with a one-pass algorithm using only constant space?
 */
public class Medium_SortColors_75 {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int red = 0, white = 0, blue = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                red++;
            } else if(nums[i] == 1){
                white++;
            } else{
                blue++;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(red > 0){
                nums[i] = 0;
                red--;
            } else if(white > 0){
                nums[i] = 1;
                white--;
            } else if(blue > 0){
                nums[i] = 2;
                blue--;
            }
        }
        return;
    }
}
