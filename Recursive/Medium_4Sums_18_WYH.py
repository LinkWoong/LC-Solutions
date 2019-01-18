
# coding: utf-8

# In[1]:


class Solution:
    def fourSum(self, nums, target):
        nums.sort()
        results = []
        self.findNsum(nums, target, 4, [], results)
        return results
#算法思路：
#step1:sort整个数列
#step2:利用recusive函数的方法，将N-sum最终变为2-sum
#step3:从左往右找到sort后的数列中可能会成为和数的数字，从数列中删除这个数字，降低N，再次调用函数
#step4:只有在找到全部N个和数的情况下（在最后N=2的情况中找到最后两个和数），这N个和数才会被加入最终返回的结果
    def findNsum(self, nums, target, N, result, results):
        if len(nums) < N or N < 2: return
        if N == 2:
            l,r = 0,len(nums)-1
            while l < r:
                if nums[l] + nums[r] == target:
                    results.append(result + [nums[l], nums[r]])
                    l += 1
                    r -= 1
                    while l < r and nums[l] == nums[l - 1]:
                        l += 1
                    while r > l and nums[r] == nums[r + 1]:
                        r -= 1
                elif nums[l] + nums[r] < target:
                    l += 1
                else:
                    r -= 1
        else:
            for i in range(0, len(nums)-N+1):   # 从小到大找N个加数中的第一个加数，所以它在序列中最大的情况即为indice=len(nums)-N+1
                if target < nums[i]*N or target > nums[-1]*N:  # 剩下的数列中的数过小或过大，不可能找到合适的数
                    break
                if i == 0 or i > 0 and nums[i-1] != nums[i]:  # and后的条件确保只取一次数，避免重复
                    self.findNsum(nums[i+1:], target-nums[i], N-1, result+[nums[i]], results)
        return

