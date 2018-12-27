package LeetCode;

public class Hard_TrappingRainWater_42_LMY {
    /*

    https://leetcode.com/problems/trapping-rain-water/


        Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


    The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

    Example:

    Input: [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6

     */
    //这个思路比较容易理解
    //动态编程 先遍历获得区间左右最大值再计算
    public int trap(int[] height) {
        int length = height.length;
        //leftMax数组
        int[] left = new int[length];
        //rightMax数组
        int[] right = new int[length];

        int leftMax = 0;
        int rightMax = 0;
        for(int i = 0 ; i<length ; i++){
            leftMax = left[i] = Math.max(leftMax,    height[i]);
            rightMax = right[length-i-1] = Math.max(rightMax, height[length-i-1]);
        }
        int result = 0;
        for(int j = 0 ; j<length ; j++){
            result += Math.min(left[j], right[j]) - height[j];
        }
        return result;

        }
    }
