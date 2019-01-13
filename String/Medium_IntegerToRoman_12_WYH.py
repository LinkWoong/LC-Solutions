
# coding: utf-8

# In[13]:


class Solution:
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
      #算法思路：
      #罗马数字可以拆分为一个个字符，将这些个字符所代表的数字加在一起，就是我们要的结果
      #这道题的难点，在于找出罗马数字里的这些字符
      #罗马数字字符的可以总结为两点：
      # (1)每个1*10^n，5*10^n,10*10^n的数字都会有一个单独的字符表示,（1 I，5 V，X 10,L 50,C 100....）
      # (2)每个4*10^n，9*10^n的数字，都会用一个‘char(l-1)’+'char(l)'或char(l-2)’+'char(l)'的形式表示，（4 IV,9 IX,40 XL,90 XC....）
      # 找出这个规律之后，我们就可以用先排除大数在讨论小数的方法，找到所有字符，并把它们所对应的数字加起来
        strs = ['M', 'CM', 'D', 'CD', 'C', 'XC', 'L', 'XL', 'X', 'IX', 'V', 'IV', 'I']
        nums = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]        
        ret = ""        
        for i, j in enumerate(nums):
            while num >= j:
                ret += strs[i]
                num -= j
            if num == 0:
                return ret

