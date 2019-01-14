
# coding: utf-8

# In[1]:


class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        #算法思路：
        #step1:将输入的一个list的整数从小到大排列
        #step2:利用a+b+c=0等效于a+b=-c,从最小的一个开始遍历,找到这个数的后面的两个的和是这个的负数的数
        #step3:像上步所述,在某个list整数的遍历中包含一个它之后数的遍历,采取首位相加的思路,如果小于target则首向后移一个,如果大于,尾向前移一位
        #当和与target相等的时候,满足要求,输出结果
        nums.sort()
        N, result = len(nums), []
        for i in range(N):
        ########################################  target选择中避免重复,因为已经排序,避免相邻的相等即可避免重复  
            if i > 0 and nums[i] == nums[i-1]:
                continue
         #########################################       
            target = nums[i]*-1
            s,e = i+1, N-1
            while s<e:
                if nums[s]+nums[e] == target:
                    result.append([nums[i], nums[s], nums[e]])
                    s = s+1
         #############################################  找两个加数中避免重复,因为已经排序,避免相邻的相等即可避免重复
                    while s<e and nums[s] == nums[s-1]:
                        s = s+1
          ############################################          
                elif nums[s] + nums[e] < target:  #小于
                    s = s+1
                else:
                    e = e-1  #大于
        return result

