
# coding: utf-8

# In[ ]:


#算法思路：
#pop sort 冒泡排序
class Solution:
    def sortColors(self, nums):
        """
        Do not return anything, modify nums in-place instead.
        """
        tem = 0  
        n = len(nums)
        flag = 1 
        while(flag):
            flag = 0
            for i in range(1, n):
                if nums[i]<nums[i-1]:
                    flag = 1
                    tem = nums[i-1]
                    nums[i-1] = nums[i]
                    nums[i] = tem
                

