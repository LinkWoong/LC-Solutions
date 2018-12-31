
# coding: utf-8

# In[29]:


#Runtime: 108 ms, faster than 94.14%
class Solution:
    # @return a string
    def longestPalindrome(self, s):
        if len(s)==0:
            return ""
        Length=1
        begin=0
        
        #算法基本思路: 
        #step 1: 从左往右搜寻初始回文string的中心（有两种情况，分别对应以下forloop中的两个if）
        #case 1：回文string中心是三个字符（ex:aba）
        #case 2: 回文string中心是两个字符（ex:aa）
        #step 2: 找到回文的中心后，去探究中心的前后是否是同一个字符（ex:xabax,whether two x is the same)
        #step 3: 如果step 2中两个x是一样的，那么继续探究下一组前后的x是否一样
        #        如果不一样，保存好现在这个回文string的起末indices，然后那么往右继续搜寻下一个长度大于或者等于这个回文string的回文string
        for i in range(len(s)):
            if i-Length >=1 and s[i-Length-1:i+1]==s[i-Length-1:i+1][::-1]:
                begin=i-Length-1
                Length+=2
                continue

            if i-Length >=0 and s[i-Length:i+1]==s[i-Length:i+1][::-1]:
                begin=i-Length
                Length+=1
        return s[begin:begin+Length]

