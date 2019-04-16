
# coding: utf-8

# In[4]:


#算法思路：
#Recursive
#对之前的结果的set每次新加一个后尾的数字，得到一个新的set，然后将它们加在一起
#EX：（1,2,3）
#1->[],[1]
#[],[1]->[2],[1,2]->[],[1],[2],[1,2]
#[],[1],[2],[1,2]->[3],[1,3],[2,3],[1,2,3]->[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]
class Solution:
    def subsets(self, nums):
        res = []
        if len(nums) == 1:
            return [res,nums]#base case
        tem = nums.pop()
        res += self.subsets(nums)
        for i in range(len(res)):
            res.append([tem]+res[i])
        
        return res

