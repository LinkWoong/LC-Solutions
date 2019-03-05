
# coding: utf-8

# In[ ]:


#算法思路：
#动态规划的思路
#新建一个m*n的矩阵dp
#dp[m][n]即代表map大小为m*n时的unique path的数量
class Solution:
    def uniquePaths(self, m, n):
        if m == 1 or n == 1:
            return 1
        dp = [[0]*n]*m
        
        for i in range(m):
            dp[i][0] = 1
            
        for i in range(n):
            dp[0][i] = 1
        
        for i in range(1,m):
            for j in range(1,n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
         
        return dp[m-1][n-1]
        

