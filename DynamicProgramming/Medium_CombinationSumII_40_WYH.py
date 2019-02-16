
# coding: utf-8

# In[1]:


#算法思路：
#动态规划的思路，跟上一题类似
#定义动态规划结果dp，dp为一个全是set的list,dp[i]中装有的是和为i时所有的combination
class Solution(object):
    def combinationSum2(self, candidates, target):
        candidates.sort()#保证从最小数加起
        dp = [set() for i in range(target+1)]#注意dp的size应该是target+!
        dp[0].add(())#定义dp中的第一个结果，当和为0是，它是一个空集（已经假设candidate中都是正整数）
        for num in candidates:
            for t in range(target, num-1, -1):
                for prev in dp[t-num]:
                    dp[t].add(prev + (num,))
        return list(dp[-1])

