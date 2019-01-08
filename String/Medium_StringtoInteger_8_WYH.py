
# coding: utf-8

# In[ ]:


class Solution(object):
    def myAtoi(self, s):
        """
        :type str: str
        :rtype: int
        """
        #算法思路：
        #Step1:如果空字符串,则直接返回0
        #Step2:如果全为whitespaces,则直接返回0
        #Step3:如果第一个非空格字符是正负号，根据正负号,赋值sign以1或-1
        #Step4：如果第一个非空格字符是数字，或第一个非空格字符是正负号，第二个字符是数字，则遍历这个以这个数字为首的数字串，得到它的值
        if len(s) == 0 : return 0
        ls = list(s.strip())
        if len(ls) == 0 : return 0
        
        sign = -1 if ls[0] == '-' else 1
        if ls[0] in ['-','+'] : del ls[0]
        ret, i = 0, 0
        while i < len(ls) and ls[i].isdigit() :
            ret = ret*10 + ord(ls[i]) - 48#0在ASCII表中第48个
            i += 1
        return max(-2**31, min(sign * ret,2**31-1))

