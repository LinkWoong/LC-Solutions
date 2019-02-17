
# coding: utf-8

# In[1]:


#算法思路：
#将输入的整数list排序
#定义的一个res的variable,初始量是1
#对排列好的list进行遍历
#找到等于res的element后，对res加一，即在list的1之后继续找2
#如果找不到2，则2就成为了第一个没有的正整数
#其他情况，以此类推
class Solution:
    def firstMissingPositive(self, nums):
        nums.sort()
        res = 1
        for num in nums:
            if num == res:
                res += 1
        return res
        

