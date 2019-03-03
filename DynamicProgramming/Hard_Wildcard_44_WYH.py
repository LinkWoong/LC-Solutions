
# coding: utf-8

# In[2]:


class Solution:
#算法思路：运用DP算法
#在这里我们从pattern的左边向右边判断，遇到*，我们就开始新一轮的match
    def isMatch(self, s, p):
        length = len(s)
        if len(p) - p.count('*') > length:#impossible case：pattern中除开*的letter长度大于了string的长度
            return False
        dp = [True] + [False]*length#定义DP为一个长度和string一样的list,我们需要从左开始判断
        for i in p:
            if i != '*':
                for n in reversed(range(length)):
                    dp[n+1] = dp[n] and (i == s[n] or i == '?')#只有前面的都match上了,才能保证最后能march
            else:
                for n in range(1, length+1):#以下三行表示,我们不止到*会持续多久,所以如果*之前都match上了,我们便把dp[1:end]全部变成true,可以开始*后下一波的match
                    dp[n] = dp[n-1] or dp[n]
            dp[0] = dp[0] and i == '*'
        return dp[-1]

