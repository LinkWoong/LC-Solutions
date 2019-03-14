
# coding: utf-8

# In[4]:


#算法思路：
#DP算法：
#建立一个dp matrix table
#这个table[i,j]代表word1[i::]和word[j::]的minimum distance
class Solution:
    def minDistance(self, word1, word2):
        m = len(word1)
        n = len(word2)
        table = [[0] * (n + 1) for _ in range(m + 1)]

        for i in range(m + 1):#base case
            table[i][0] = i
        for j in range(n + 1):
            table[0][j] = j
            
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if word1[i - 1] == word2[j - 1]:
                    table[i][j] = table[i - 1][j - 1]#相同字符
                else:
                    table[i][j] = 1 + min(table[i - 1][j], table[i][j - 1], table[i - 1][j - 1])#minimum replacement
        return table[-1][-1]
        

