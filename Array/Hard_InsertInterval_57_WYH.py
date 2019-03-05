
# coding: utf-8

# In[ ]:


#算法思路：
#算法跟上一问的一样，除了把这个函数的两个输入合并成了上个函数的输入以外
# Definition for an interval.
# class Interval:
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution:
    def insert(self, intervals, newInterval):
        intervals += newInterval,
        out = []
        for i in sorted(intervals, key=lambda i: i.start):
            if out and i.start <= out[-1].end:
                out[-1].end = max(out[-1].end, i.end)
            else:
                out += i,
        return out
        
        
        
        
        
        
    
        

