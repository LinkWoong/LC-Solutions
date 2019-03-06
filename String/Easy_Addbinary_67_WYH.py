
# coding: utf-8

# In[1]:


#算法思路：
#用eval()函数将二进制数转化为十进制数运算
#将十进制数运算的结果再转换为二进制数
class Solution:
    def addBinary(self, a, b):
        return bin(eval('0b' + a) + eval('0b' + b))[2:]

