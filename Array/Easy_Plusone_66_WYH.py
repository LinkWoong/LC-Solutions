
# coding: utf-8

# In[ ]:


#算法思路：
#最后一位单独谈论
#定义一个判断是否进位的变量carry
#如果第一位都还在进位
#则在左侧添加一个1
class Solution:
    def plusOne(self, digits):
        n = len(digits)
        carry = 0
        cur = n-1
        if digits[cur] == 9:
            digits[cur] = 0
            carry =1
            cur -= 1  
        else:
            digits[cur] += 1
            return digits
            
        while(carry):
            if cur == -1:
                digits.insert(0,1)
                return digits
            
            if digits[cur] == 9:
                digits[cur] = 0
                carry = 1
                cur -= 1
                
            else:
                digits[cur] += 1
                return digits
        
                
        

