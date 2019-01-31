
# coding: utf-8

# In[ ]:


class Solution:
#算法思路：
#这里的两种情况：
#（1）在sorted array中存在target,返回target indice
# (2) 在sorted array中不存在target，返回target应插入的indice
#都可以转化为sorted array中小于target的数字的个数减1
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        return len([x for x in nums if x<target])

