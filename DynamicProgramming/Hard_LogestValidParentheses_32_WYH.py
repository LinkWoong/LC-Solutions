
# coding: utf-8

# In[1]:


class Solution:
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
#算法思路：用动态规划的思路,创建一个名叫dp的list，dp[i]是以s[i]为止的最长的valid parentheses的长度
#由此，我们可以将valid parentheses的数量变化分为三种情况
        dp = [0 for x in range(len(s))]
        max_to_now = 0
        for i in range(1,len(s)):
            if s[i] == ')':# case 1: ()()
                if s[i-1] == '(':# add nearest parentheses pairs + 2                    
                    dp[i] = dp[i-2] + 2                                
                elif i-dp[i-1]-1 >= 0 and s[i-dp[i-1]-1] == '(':# case 2: (()) i-dp[i-1]-1 is the index of last "(" not paired until this ")"
                    if dp[i-1] > 0: # content within current matching pair is valid   
                                     # add nearest parentheses pairs + 2 + parentheses before last "("
                   
                        dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2] #加上之前的，例如()((())))，加上之前()的2“
                    else:    # otherwise is 0
                    
                        dp[i] = 0
                max_to_now = max(max_to_now, dp[i])
        return max_to_now

