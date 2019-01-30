
# coding: utf-8

# In[1]:


class Solution:
#算法思路：用binary search的最直接的方法
#注意的是这里，我们最理想的假设是pivot就是mid的位置
#但稍加条件牵制，就可以对付pivot不在mid上的情况
#最开始判断mid是否大于最左端，如果是则pivot在mid右边，不是则反之
#通过大小的判断，改变左端右端low和high的数值，最后锁定住target(low>high)
#搜寻范围向左挤，或者向右挤，挤到target为止
    def search(self, nums, target):
        if not nums:
            return -1

        low, high = 0, len(nums) - 1

        while low <= high:
            mid = int((low + high) / 2)
            if target == nums[mid]:
                return mid

            if nums[low] <= nums[mid]:
                if nums[low] <= target <= nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[mid] <= target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1
        

