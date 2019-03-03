
# coding: utf-8

# In[82]:


class Solution:
    #算法思路：从左往右，一步一步地找到通往end的路径，每一次在当初起点后面遍历此刻可以跳到的点
    #在这些点中找到i+nums[i]最大的数，即为下下次jump到的点
    #找到后这个点定为下次的end，这次的end+1定为下次的start
    def jump(self, nums):
        n, start, end, step = len(nums), 0, 0, 0
        while end < n - 1:
            step += 1
            maxend = end + 1
            for i in range(start, end + 1):
                if i + nums[i] >= n - 1:
                    return step
                maxend = max(maxend, i + nums[i])
            start, end = end + 1, maxend
        return step

