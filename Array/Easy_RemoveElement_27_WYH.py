
# coding: utf-8

# In[ ]:


class Solution:
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        read, write=0 ,0
#算法思路：
#step1:创建两个整数，read和write
#step2:将read和write作为indices,遍历整个list 
#step3:当nums[read]==vals时，更新read+1，continue跳到循环头
#step4：不等于时，赋值 nums[write]=nums[read]，更新read+1,write+1
        if not nums:
            return 0
        
        end = len(nums)
        
        while read < end:
            if nums[read]==val:
                read+=1
                continue
                
            nums[write]=nums[read]
            write+=1
            read+=1
        
        nums=nums[0:write]
            
        return len(nums)
    

