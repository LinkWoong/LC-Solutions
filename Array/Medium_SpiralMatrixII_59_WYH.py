
# coding: utf-8

# In[ ]:


#算法思路：
#非常基本的思路
#新建一个全为0的n*n矩阵
#从A[0][0]开始
#顺时针沿着spiral的路线到达A的中心
class Solution:
    def generateMatrix(self, n: 'int') -> 'List[List[int]]':
        start = 1
        end = n*n
        
        matrix = [[0]*n for _ in range(n)]
        
        rowStart, rowEnd = 0, n-1
        colStart, colEnd = 0, n-1
        while rowStart <= rowEnd and colStart<=colEnd:
            # right
            for i in range(colStart, colEnd+1):
                matrix[rowStart][i] = start
                start += 1
            rowStart += 1
            
            # Down
            for i in range(rowStart, rowEnd + 1):
                matrix[i][colEnd] = start
                start += 1
            colEnd -= 1
            
            # left
            if rowStart<= rowEnd:
                for i in range(colEnd, colStart-1, -1):
                    matrix[rowEnd][i] = start
                    start += 1
                rowEnd -= 1
            
            # up
            if colStart <= colEnd:
                for i in range(rowEnd, rowStart-1,-1):
                    matrix[i][colStart] = start
                    start += 1
                colStart += 1
        return matrix

