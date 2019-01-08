
# coding: utf-8

# In[ ]:


#Runtime: 476 ms, faster than 30.30% 
class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        #算法思路
        #Step1:将integer输入转换为string
        #Step2:从转换的string的首末开始判断是否两个字符一样，一直到string的中心为止
        string=str(x)
        length=len(string)
        mid= length//2
        identifier=True
        
        for i in range(mid):
            identifier*=(string[i]==string[~i])
            
        return identifier==1

