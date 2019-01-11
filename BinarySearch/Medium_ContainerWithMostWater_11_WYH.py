
# coding: utf-8

# In[1]:


class Solution:
    def maxArea(self, height, result = 0, L = 0):
        if not height: return 0
        R = len(height)-1
        #算法思路：将输入的list格式的heights想象成一个柱状统计图，我们要找出由两条柱子组成的装水容量最大的杯子
        #从最两边的柱子开始计算，注意装水容量取决于小的那根柱子
        #遍历往中间靠，注意向中间靠的方向是从小柱子往大柱子，因为另一个方向已经不会找出更大容积的杯子了
        while L != R:
            result = max(result, min(height[L], height[R])*(R-L))
            if height[L] < height[R]:
                L += 1
            else:
                R -= 1                
        return result

