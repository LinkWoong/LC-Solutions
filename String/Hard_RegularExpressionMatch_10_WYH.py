
# coding: utf-8

# In[180]:


#算法思路：从两个string的末尾开始检测，符合就删掉检查过的地方，最后剩下的部分会有三种情况（见第四行开始）
class Solution:
    def isMatch(self, s, p, memo={("",""):True}):
        if not p and s:      return False     #pattern还有，但string已删完
        if not s and p:      return set(p[1::2]) == {"*"} and not (len(p) % 2) # pattern为字母*和 string为空
        if (s,p) in memo:    return memo[s,p] #string和pattern双双被同时删空
        
        char, exp, prev = s[-1], p[-1], 0 if len(p) < 2 else p[-2]
        memo[s,p] =               (exp == '*' and ((prev in {char, '.'} and self.isMatch(s[:-1], p, memo)) or self.isMatch(s, p[:-2], memo)))               or               (exp in {char, '.'} and self.isMatch(s[:-1], p[:-1], memo))
        #p末尾是*&&（（p倒数第二个是s的末尾或者.&&去掉s最后一项，call自己返回的值)\\（去掉p最后两项，call自己返回的值））\\
        #（p的倒数第一个是s的倒数第一个或者.&&各去掉s和p的最后一项，call自己返回的值）
        return memo[s,p]

