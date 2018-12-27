package LeetCode;

public class Easy_MaximumSubarray_53_LMY {

    /*
        Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

    Example:

    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
    Follow up:

    If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

     */
    //accepted on 2018/12/26
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = Integer.MIN_VALUE, before = 0, after = 0;
        for(int i = 0; i < nums.length; i++){
            if(sum > 0){
                sum = sum + nums[i];
            }
            else{
                sum = nums[i];
            }
            if(sum > maxSum)
                maxSum = sum;
        }
        return maxSum;
    }

}
