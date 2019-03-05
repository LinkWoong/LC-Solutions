
# coding: utf-8

# In[20]:


#算法思路：
#从左向右遍历整个array
#检查当前可以最大达到的数max_reach,能否跟上current脚步数i
#如果跟不上则返回False,跟得上并且超越了终点则返回True
class Solution:
    def canJump(self, nums):
        max_reach, n = 0, len(nums)
        for i, x in enumerate(nums):
            if max_reach < i: return False
            if max_reach >= n - 1: return True
            max_reach = max(max_reach, i + x)

