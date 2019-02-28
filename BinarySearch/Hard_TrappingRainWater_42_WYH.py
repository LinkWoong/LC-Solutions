
# coding: utf-8

# In[92]:


#算法思路：
#单个bar积雨的体积等于，这个bar左右最大的bar的小的一个的高度减去这个bar本身的高度
#如此一来，我们在每个bar上做这样减法的运算，将其结果加起来就是我们想要的答案
#关键在于怎么找到一个bar的左右最大的bar中小的那个bar的高度
#我们可以利用类似binary search的方法
#然后利用一个trick:在找左右最高bar的时候，我们不用真的找到确实的最高的bar
#比如在这里我们找到的是一边确切的最高的bar，和另外一边靠外部分的最高的bar
#如果比另外一边部分bar中的最高bar的要低，那一定比那一边的真正的最高的矮
#利用这一点，我们就能用binary search的算法了

class Solution:
    def trap(self, bars):
        if not bars or len(bars) < 3:
            return 0
        volume = 0
        left, right = 0, len(bars) - 1
        l_max, r_max = bars[left], bars[right]
        while left < right:
            l_max, r_max = max(bars[left], l_max), max(bars[right], r_max)
            if l_max <= r_max:
                volume += l_max - bars[left]
                left += 1
            else:
                volume += r_max - bars[right]
                right -= 1
        return volume
        

