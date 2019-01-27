
# coding: utf-8

# In[ ]:


class Solution:
    #算法思路：
    #根据next greater permutation的定义：
    #step1：找到数列末尾的非increasing的sub数列的左边第一个数字作为pivot
    #step2: 在末尾非increasing的sub数列中，从右往左遍历，找到第一个大于pivot的数作为successor
    #step3: 对pivot和successor交换位置
    #step4: 对这个交换了的数列的末尾的sub数列（以之前确定的indices为准），reverse它的顺序
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        # find longest non-increasing suffix
        right = len(nums)-1
        while nums[right] <= nums[right-1] and right-1 >=0:
            right -= 1
        if right == 0:
            self.reverse(nums,0,len(nums)-1)
        # find pivot
        pivot = right-1
        successor = 0
        # find rightmost succesor
        for i in range(len(nums)-1,pivot,-1):
            if nums[i] > nums[pivot]:
                successor = i
                break
        # swap pivot and successor
        nums[pivot],nums[successor] = nums[successor],nums[pivot]  
        # reverse suffix
        self.reverse(nums,pivot+1,len(nums)-1)
        
    def reverse(self,nums,l,r):
        while l < r:
            nums[l],nums[r] = nums[r],nums[l]
            l += 1
            r -= 1
        

