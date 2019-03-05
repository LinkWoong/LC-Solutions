
# coding: utf-8

# In[1]:


#算法思路：将solution的位置当成tree，使用DFS算法
#注意Queen的走位规则，直角和45°角都可以直达
#有四个argument:
#nums:Q在每一行的位置
#index：current saerch depth
#path: 当前解法之前search过的每行的具体情况
#res: 用来放置所有solution的一个变量
class Solution:
    def solveNQueens(self, n):
        res = []
        self.dfs([-1]*n, 0, [], res)
        return res
 
# nums is a one-dimension array, like [1, 3, 0, 2] means
# first queen is placed in column 1, second queen is placed
# in column 3, etc.
    def dfs(self, nums, index, path, res):
        if index == len(nums):#到达子叶，只有成功达到合适解法的子叶，最后才能被加入res当中
            res.append(path)
            return  # backtracking
        for i in range(len(nums)):#遍历每个走法
            nums[index] = i
            if self.valid(nums, index):  # pruning，检验在这个地方放置queen是否与前面矛盾，矛盾则终止这条path，它为不适合解法的子叶
                tmp = "."*len(nums) #未放置queen
                self.dfs(nums, index+1, path+[tmp[:i]+"Q"+tmp[i+1:]], res)

# check whether nth queen can be placed in that column
    def valid(self, nums, n):
        for i in range(n):
            if abs(nums[i]-nums[n]) == n -i or nums[i] == nums[n]:
                return False
        return True
        

