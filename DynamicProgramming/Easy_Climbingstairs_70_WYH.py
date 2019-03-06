
# coding: utf-8

# In[ ]:


#算法思路：
#利用动态规划的思路
#dp[n]代表n+1长度的梯子到达终点可能得步数
#有dp[n]=dp[n-1]+dp[n-2]的关系
#dp[n-1]代表从前一个梯子一步走到终点
#dp[n-2]代表从前秦个梯子两步走到终点
class Solution:
    def climbStairs(self, n):
        if n == 1:
            return 1
        dp = [0 for i in range(n)]
        dp[0], dp[1] = 1, 2
        for i in range(2, n):
            dp[i] = dp[i-1] + dp[i-2]
        return dp[-1]
        

