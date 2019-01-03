
# coding: utf-8

# In[2]:


class Solution:    
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        #思路：
        #得到x的sign后，运用它取x的绝对值，将它转换为string再做reverse
        #reverse后的string再转化为integer
        #如果这个integer大于了2^31-1，则返回零，否之，则返回sign(x)与这个integer的乘积
        #值得注意的是在python里，int('000023')=23
        sign = lambda x: x and (1, -1)[x < 0]
        r = int(str(sign(x)*x)[::-1])
        return (sign(x)*r, 0)[r > 2**31 - 1]

