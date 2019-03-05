
# coding: utf-8

# In[63]:


#算法思路：
#从array的头开始遍历
#从头开始累加，累加时要判断
#如果之前的sum小于了零，就不加上去
#而从新的地方开始累加
class Solution:
    def maxSubArray(self, nums):
        for i in range(1, len(nums)):
            if nums[i-1] > 0:
                nums[i] += nums[i-1]
        return max(nums)

