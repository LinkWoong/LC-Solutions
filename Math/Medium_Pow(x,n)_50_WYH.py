
# coding: utf-8

# In[1]:


#算法思路：
#利用recursive的方法
#n小于0时要分开讨论
#重点是要降低代码的时间复杂度
#当n为偶数的时候，我们可以将次方放在x上面，n减半
class Solution:
    def myPow(self, x, n):
        if not n:
            return 1
        if n < 0:
            return 1 / self.myPow(x, -n)
        if n % 2:
            return x * self.myPow(x, n-1)
        return self.myPow(x*x, n/2)

