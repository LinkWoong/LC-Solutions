
# coding: utf-8

# In[21]:


#算法思路：
#采用按digit分组查找的机制
#第一个digit的组最大,后面以此减小
#查完一个组即加上对应digit的数组
#然后从组里remove掉已加上的数字,使它变成一个小组

from math import factorial  
class Solution(object):

    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        res = []
        nums = [i for i in range(1, n+1)]
        while n-1 >= 0:
            num, k = k/factorial(n-1), k % factorial(n-1)
            if k > 0:
                res.append(str(nums[int(num)]))
                nums.remove(nums[int(num)])
            else:
                res.append(str(nums[int(num-1)]))#除尽了，刚好分到了上一组的最后一个
                nums.remove(nums[int(num-1)])

            n -= 1

        return ''.join(res)

