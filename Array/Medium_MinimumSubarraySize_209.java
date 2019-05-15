package Leetcode;

public class Medium_MinimumSubarraySize_209 {
    public static void main(String[] args){
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));
    }
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int p1 = 0, p2 = 0;
        int sum = 0, res = Integer.MAX_VALUE;

        while(p2 < nums.length){
            while(p2 < nums.length && sum < s){
                sum += nums[p2];
                p2++;
            }
            while(p1 < p2 && sum >= s){
                sum -= nums[p1];
                p1++;
            }
            res = Math.min(res, p2 - p1 + 1);
        }
        return res;
    }
}
