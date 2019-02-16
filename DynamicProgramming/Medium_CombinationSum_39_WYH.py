
# coding: utf-8

# In[1]:


class Solution:
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
#算法思路：
#定义一个跟target一个长度的list m
#使这个list m中，m[i] 中装的是所有加起来为target-i的combination of candidate
#所以m[0]即为我们想要的解

        m = [[] for _ in range(target + 1)]
        for n in candidates:
            m[target - n].append([n])#按candidate加入第一个数

            for s in range(target-1, n-1, -1):#为了找到其他的m[i],我们需要遍历candidate中的元素，将可以存在的m[i]由之前的m[i]加上当前遍历到的n来得到
                for entry in m[s]:
                    m[s - n].append(entry + [n])
        return m[0]

