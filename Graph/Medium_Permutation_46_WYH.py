
# coding: utf-8

# In[1]:


#算法思路：
#采用DFS算法
#将nums中的所有元素当成一个互相相连的树
#树的root可以从任意一个element开始
#找到每个数到达leave的路径，即能找到所有permutation的方法
class Solution:
    def permute(self, nums):
        res = []
        self.dfs(nums, [], res)
        return res
    
    def dfs(self, nums, path, res):
        if not nums:
            res.append(path)
        # return [[]]
        for i in range(len(nums)):
            self.dfs(nums[:i]+nums[i+1:], path+[nums[i]], res)#这里path代表已走的路，nums位置的argument代表未走的路
        

