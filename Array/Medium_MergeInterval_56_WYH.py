
# coding: utf-8

# In[1]:


# Definition for an interval.
# class Interval:
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e
#算法思路:
#为了找到overlapped的list,首先按list们的左边界作为排序标准排序
#对排序好了的相邻list进行判断,如果overlap则进行合并(将已经放入的list的右边界进行延伸)
#由此将所有list重新串起来
class Solution:
    def merge(self, intervals):
        out = []
        for i in sorted(intervals, key=lambda i: i.start):
            if out and i.start <= out[-1].end:
                out[-1].end = max(out[-1].end, i.end)
            else:
                out += i,#子list加法
        return out
        

