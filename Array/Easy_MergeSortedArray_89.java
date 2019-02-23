package Leetcode;

import java.util.Arrays;

/*
    Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

    Note:

    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
    Example:

    Input:
    nums1 = [1,2,3,0,0,0], m = 3
    nums2 = [2,5,6],       n = 3

    Output: [1,2,2,3,5,6]
*/
public class Easy_MergeSortedArray_89 {
    // 思路1：直接从index=m开始nums1[index]=nums2[index2]，最后再sort。o(nlogn)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1.length == 0 || nums2.length == 0)
            return;
        int start = 0;
        for(int i = m; i < nums1.length; i++){
            nums1[i] = nums2[start];
            start++;
        }
        Arrays.sort(nums1);
    }

    // 思路2：双指针。p1, p2分别从nums1, nums2的m和n处开始，同时用一个变量记录nums1的尾部
    // 比较nums1和nums2的最大元素，将较大者放到nums1的尾部，更新较大者的指针和尾部变量
    // 如果p2还不为0，说明nums2中存在比nums1还要小的元素，而此时nums1中所有的元素已经挪到后面去了
    // 所以直接将nums2剩余的元素依次赋给nums1
    public void merget_v2(int[] nums1, int m, int[] nums2, int n){
        if(nums1.length == 0 || nums2.length == 0)
            return;
        int p1 = m - 1;
        int p2 = n - 1;
        int total = m + n - 1;
        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] > nums2[p2]){
                nums1[total] = nums1[p1];
                p1--;
            }
            else{
                nums1[total] = nums2[p2];
                p2--;
            }
            total--;
        }

        while(p2 >= 0){
            nums1[p2] = nums2[p2];
            p2--;
        }
    }
}
