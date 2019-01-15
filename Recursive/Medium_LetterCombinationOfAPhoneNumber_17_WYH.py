
# coding: utf-8

# In[5]:


class Solution:
    # @param {string} digits
    # @return {string[]}
    # 算法思路：
    # 用recursive的思路，方程中调用方程
    # 从输入数字string的末尾开始decode，并把末尾decode的所有的可能保存为list
    # 将末尾砍掉的数字string作为输入进入方程中自己的方程
    def letterCombinations(self, digits):
        mapping = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', 
                   '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
        if len(digits) == 0:
            return []
        if len(digits) == 1:
            return list(mapping[digits[0]])
        prev = self.letterCombinations(digits[:-1])
        additional = mapping[digits[-1]]
        return [s + c for s in prev for c in additional]

