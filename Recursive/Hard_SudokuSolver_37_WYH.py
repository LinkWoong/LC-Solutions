
# coding: utf-8

# In[ ]:


class Solution:
#算法思路：
#核心是recuisive，尝试一遍当前的可用解，当最后发现出现无解的情况时，判断为错误解，并返回最初assign可用解时，把这个槽位重新置空
#并对后面的槽位开始排解，之后又回到这个槽位来再次找解
#方程findUnassigned：按遍历顺序找到当前第一个没有数的槽位
#方程isSafe: 对这个槽位进行排解，按1,2,3...的顺序试满不满足要求
#方程solve: 对整个board进行数独计算

    def solveSudoku(self, board):
        self.board = board #传入board
        self.solve()
    
    def findUnassigned(self):
        for row in range(9):
            for col in range(9):
                if self.board[row][col] == ".":
                    return row, col
        return -1, -1
    
    def solve(self):
        row, col = self.findUnassigned()
        if row == -1 and col == -1: #所有槽位都有了解
            return True
        for num in ["1","2","3","4","5","6","7","8","9"]:
            if self.isSafe(row, col, num):
                self.board[row][col] = num #assign一个当前可用解
                if self.solve():#判断这个当前可用解是否是真的解
                    return True
                self.board[row][col] = "."#不是，则把这个槽位再次置空，先对剩下的槽位进行运算
        return False
            
    def isSafe(self, row, col, ch):
        boxrow = row - row%3
        boxcol = col - col%3
        if self.checkrow(row,ch) and self.checkcol(col,ch) and self.checksquare(boxrow, boxcol, ch):
            return True
        return False
    
    def checkrow(self, row, ch):
        for col in range(9):
            if self.board[row][col] == ch:
                return False
        return True
    
    def checkcol(self, col, ch):
        for row in range(9):
            if self.board[row][col] == ch:
                return False
        return True
       
    def checksquare(self, row, col, ch):
        for r in range(row, row+3):
            for c in range(col, col+3):
                if self.board[r][c] == ch:
                    return False
        return True

