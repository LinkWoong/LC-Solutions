
# coding: utf-8

# In[ ]:


class Solution:
#算法思路：
#需要理解count and say sequence的变化规律
#最初始的一定是1
#然后是1个1（11）
#然后是两个1（21）
#然后是一个2一个1（1211）。。。。
#我们每次找到下一个squence，都需要对前一个squence进行一次遍历，如果找到n个sequence就需要n次遍历
#每次sequence遍历的规则如下：
#设有一个let和一个count，let=string[0], 然后遍历整个sequence
#遇到之后与let相等的则count+1
#遇到不同的则更新let和count，开始下一轮的搜寻
    def countAndSay(self, n):
        s = '1'
        for _ in range(n-1):
            let, temp, count = s[0], '', 0
            for l in s:
                if let == l:
                    count += 1
                else:
                    temp += str(count)+let
                    let = l
                    count = 1
            temp += str(count)+let
            s = temp
        return s
        

