
# coding: utf-8

# In[59]:


class Solution:
#算法思路：
#写一个recursive的函数,定义right=left=n,分别表示'('和')'的个数,定义p,p是一个未完善的parentheses
#在这个方程中，依照right和left的大小，分别给p做三种平行操作：
#（1）left>0,p后面加上一个‘(’
#（2）right>left,p后面加上一个')'
#（3）right为0,这个p已经完成,将p加入事先定义的总集parens中
    def generateParenthesis(self, n):
        parens=[]
        self.generate('',n,n,parens)
        return parens
    

    def generate(self, p, left, right, parens):
        if left:         self.generate(p + '(', left-1, right, parens)#平行if，实现了找出所有parentheses排列的可能
        if right > left: self.generate(p + ')', left, right-1, parens)
        if not right:    parens += p,
                

