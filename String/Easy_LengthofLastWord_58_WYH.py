
# coding: utf-8

# In[48]:


#算法思路:
#当语句后面没有空格时
#从语句最后一个字母到它的最后一个空格之间的距离就是最后一个词语的长度
class Solution:
    def lengthOfLastWord(self,s):
        string = list(s)
        while string != [] and string[len(string)-1] == ' ':
            string.pop()
        if string == []:
            return 0
        
        count = 0
       
        for i in reversed(range(len(string))):
            if string[i] == ' ':
                break 
            count += 1
        return count

