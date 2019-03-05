
# coding: utf-8

# In[137]:


#算法思路：
#利用recursive的思路
#每次取当前矩阵最外环的数字，将这些数字计入答案res中
#当最后的矩阵为空或者为一个vector时
#将vector的所有element按顺序计入res
class Solution:
    def spiralOrder(self, matrix):
        if matrix == [] or matrix[0] == []:
            return []
        return self.Round(matrix,[])
        
        
        
        
    def Round(self,mat,res):
        if mat == [] or mat[0] == []:
            return res
        
        newmat = []
        m = len(mat)
        n = len(mat[0])
    
        if m == 1:
            for i in range(n):
                res.append(mat[0][i])
            return res
    
        if n == 1:
            for i in range(m):
                res.append(mat[i][0])
            return res
        
    
        for i in range(n):
            res.append(mat[0][i])
            #print(mat[0][i])
    
        for i in range(1,m-1):
            res.append(mat[i][n-1])
            #print(mat[i][n-1])
    
        for i in reversed(range(n)):
            res.append(mat[m-1][i])
            #print(mat[m-1][i])
    
        for i in reversed(range(1,m-1)):
            res.append(mat[i][0])
            #print(mat[i][0])
    
        for i in range(1,m-1):
            newmat.append(mat[i][1:n-1])
        
        #print(newmat)
        return self.Round(newmat,res)
    

