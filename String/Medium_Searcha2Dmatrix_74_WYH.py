
# coding: utf-8

# In[ ]:


#算法思路：
#先查矩阵每个row的第一个数字
#找到可能含有target的一行
#再在这一行中依次查找
class Solution:
    def searchMatrix(self, matrix, target):
        if not matrix or not matrix[0]:
            return False
        
        m = len(matrix)
        n = len(matrix[0])
        tem = -1
        for i in range(m):
            if matrix[i][0] > target:
                break
            else:
                tem = i
        
        if tem == -1:
            return False
        
        
        for j in range(n):
            if matrix[tem][j] == target:
                return True
        
        return False
        
        

