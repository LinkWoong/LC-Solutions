
# coding: utf-8

# In[1]:


class Solution:
# @return an integer
# 算法思路：这道题最先想到的思路就是用除数累减被除数，累减的次数就是商
# 但如果这样，那么算法就会超过时间限制
# 在不能用乘除运算的情况下，我们可以在每次累减后，使减数倍增，第二次减的时候加上的商也倍增
# 在这种思路下，为了讲除数除尽，我们需要写两个循环
# 外部的循环以被除数大于除数为继续循环条件
# 而内部的循环以被除数大于被加倍的除数为继续循环条件
    def divide(self, dividend, divisor):
        positive = (dividend < 0) is (divisor < 0)
        dividend, divisor = abs(dividend), abs(divisor)
        res = 0
        while dividend >= divisor:
            temp, i = divisor, 1
            while dividend >= temp:
                dividend -= temp
                res += i
                i <<= 1
                temp <<= 1
        if not positive:
            res = -res
        return min(max(-2147483648, res), 2147483647)#2^31=2147483648

