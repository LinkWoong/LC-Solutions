
# coding: utf-8

# In[ ]:


class Solution:
    def searchRange(self, nums, target):
#算法思路：
#首先写下一个可以找到第一个出现的target的indice的binary search的方程
#在这个方程里，如果mid的大小大于或等于target,则hi变成现在的mid
#如果mid的大小小于了target了，则lo变为现在的mid+1
#可以注意的是，因为我们在一个sorted list nums寻找，当这个方程的target变为target+1后
#这个方程会返回在nums中最后一个的target的indice+1
        def search(n):
            lo, hi = 0, len(nums)
            while lo < hi:
                mid = int((lo + hi) / 2)
                if nums[mid] >= n:
                    hi = mid
                else:
                    lo = mid + 1
            return lo
        
        lo = search(target)
        return [lo, search(target+1)-1] if target in nums[lo:lo+1] else [-1, -1] #注意应对nums=[]的情况

