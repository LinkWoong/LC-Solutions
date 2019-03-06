
# coding: utf-8

# In[ ]:


#算法思路：
#跟之前两道题都类似
#定义一个名为dp的矩阵
#矩阵的每个一个位置（m,n）都代表着到达这个点所要走的最短路径
#dp更迭的方式依然是加上（m-1,n）和（m,n-1）
#不过这次要判断哪一个比较小才加上哪一个
class Solution:
    def minPathSum(self, grid):
        m = len(grid)
        n = len(grid[0])
        for i in range(1, n):
            grid[0][i] += grid[0][i-1]
        for i in range(1, m):
            grid[i][0] += grid[i-1][0]
        for i in range(1, m):
            for j in range(1, n):
                grid[i][j] += min(grid[i-1][j], grid[i][j-1])
        return grid[-1][-1]
        

