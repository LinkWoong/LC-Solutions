
# coding: utf-8

# In[1]:


#算法思路：
#我们先从nums中取出第一个element
#然后在第一个element前后加入第二个element，两种情况
#再在这前两个的三个空位中加入第三个element，三种情况
#以此我们可以遍历出所有的情况
#不过在这道题中，我们要避免出现重复的情况，我们只插入一次，比如已有的是1，然后我们要再插入1，在原有1的左边插入一次1以后，在第二次插入前break出当次插入循环
class Solution:
    def permuteUnique(self, nums):
        ans = [[]]#case: nums is empty
        for n in nums:
            new_ans = []
            for l in ans:
                for i in range(len(l)+1):
                    new_ans.append(l[:i]+[n]+l[i:])
                    if i<len(l) and l[i]==n: break              #handles duplication
            ans = new_ans
        return ans
        

