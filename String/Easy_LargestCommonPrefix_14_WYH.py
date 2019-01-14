
# coding: utf-8

# In[99]:


class Solution:
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        #算法思路：
        #step1:空字符串返回结果“”
        #step2:找到最短字符串的长度
        #step3:从第一个字符串中截取最短长度的一段s
        #在最理想条件下,每个字符串开头的应该都有s,所以写下一个遍历的代码,去确认是不是每个字符串前面都有s
        #step4:开始遍历,遇到任何一个字符串出现不对应的时候,跳出整个循环体
        if strs==[]:
            return ""
        mini_lenth = len(strs[0])

        for i in range(len(strs)):
            mini_lenth=min(len(strs[i]),mini_lenth)
        
        s=strs[0][:mini_lenth]       
        
        for i in range(mini_lenth-1,-1,-1):
            for j in range(len(strs)):
                if s[i] != strs[j][i]:
                    s=s[:-1]
                    break
                
        return s

