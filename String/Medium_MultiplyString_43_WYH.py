
# coding: utf-8

# In[2]:


class Solution:
#算法思路：
#得到两个数num1,num2的长度m,n
#他们的积至多为m*n
#将num1分解为m位，求出它的每一位和num2的乘积
#将这些sub乘积加在一起，结果就是我们想要的积
    def multiply(self, num1, num2):
        res = [0] * (len(num1) + len(num2))
        for i in range(len(num1)-1, -1, -1):#将num1分i个digit分别乘以num2
            carry = 0
            for j in range(len(num2)-1, -1, -1):
                tmp = int(num1[i])*int(num2[j])+carry 
            # take care of the order of the next two lines
                carry = (res[i+j+1] + tmp) // 10  
                res[i+j+1] = (res[i+j+1] + tmp) % 10
            # or simply: carry, res[i+j+1] = divmod((res[i+j+1] + tmp), 10)
            res[i] += carry #每次sub乘法的最高一位加上最后得到的carry
        res = "".join(map(str, res))
        return '0' if not res.lstrip("0") else res.lstrip("0")
        

