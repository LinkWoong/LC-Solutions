
# coding: utf-8

# In[1]:


class Solution:
# 算法思路：
# 正确是parentheses就像stack,先进后出，唯一的区别是，进去的时候是左边部分“{”，“（”，“[”,
# 出去的时候是右边部分“}”，“）”，“]”
# 利用这个原理， 我们可以从第一个char开始遍历
# 遇到左边部分就放入stack里
# 遇到右边部分就去从stack里取出，这个过程中也要判断取出与放入的部分是不是相对应，不是则返回False，如果stack为空，也返回False，因为有进才有出
# 到最后所有在stack里的东西都应该被取出,stack应为空，不为空则返回False
    def isValid(self, s):
        stack = []
        dict = {"]":"[", "}":"{", ")":"("}
        for char in s:
            if char in dict.values():
                stack.append(char)#放入
            elif char in dict.keys():
                if stack == [] or dict[char] != stack.pop():#取出并判断是否对应&是否stack为空
                    return False
            else:
                return False#遇到不是这六个parentheses的字符，返回false
        return stack == []

