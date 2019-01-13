
# coding: utf-8

# In[389]:


class Solution:
# @param {string} s
# @return {integer}
#算法思路：
#利用罗马字符的特点：
#对于4,9，40,90,400,900这些数字，可以当做5-1，10-1,50-10,100-10...
#所以在罗马字符串中：
#左边字符大于右边时：加上左边这个字符的数字
#左边字符小于右边时：减去左边这个字符的数字
    def romanToInt(self, s):
        roman = {'M': 1000,'D': 500 ,'C': 100,'L': 50,'X': 10,'V': 5,'I': 1}
        z = 0
        for i in range(0, len(s) - 1):
            if roman[s[i]] < roman[s[i+1]]:
                z -= roman[s[i]]
            else:
                z += roman[s[i]]
        return z + roman[s[-1]]

