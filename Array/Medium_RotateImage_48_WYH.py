
# coding: utf-8

# In[10]:


#算法思路：
#巧妙应用zip函数的解压功能zip(*)
#zip(*)的特性就取出list中每个元组的第i个元素
#把它们组合成新的元组
#再把这些元组合并成新的list
class Solution:
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        matrix[::] = zip(*matrix[::-1])

