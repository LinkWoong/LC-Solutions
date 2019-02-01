
# coding: utf-8

# In[15]:


class Solution:
#算法思路：
#遍历整个数独board
#建立三个list:
#(a)map_row,包含9个dic; (b)map_col,包含9个dic; (c)map_cell,包含三个包含3个dic的list
#这些dic分别存储各行各列和各个cell在遍历中出现过的数字
#如果出现了重复的数字，则return false跳出循环, 如果整个遍历完整执行，则retuen true

    def isValidSudoku(self, board):
        map_row = [{} for i in range(9)]
        map_col = [{} for i in range(9)]
        map_cell = [[{} for i in range(3)] for i in range(3)]
        for i in range(9):
            for j in range(9):
                char = board[i][j]
                if char == '.': continue
                if char in map_row[i]: return False
                else: map_row[i][char] = [i,j]#这些dic中的value都没有意义
                if char in map_col[j]: return False
                else: map_col[j][char] = [i,j]
                if char in map_cell[int(i/3)][int(j/3)]: return False
                else: map_cell[int(i/3)][int(j/3)][char] = [i,j]
        return True

