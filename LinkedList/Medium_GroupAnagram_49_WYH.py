
# coding: utf-8

# In[38]:


#算法思路：
#利用hashmap来解决这个问题
#可以发现相同的anagram他们的sorted(anagram)应该是一样的
#由此我们可以将相同类型的的anagram放在同一key下
class Solution:
    def groupAnagrams(self, strs):
        d = {}
        for w in sorted(strs):
            key = tuple(sorted(w))#注意这里用tuple作为了key!!!
            d[key] = d.get(key, []) + [w]#不能使用d.get(key)，要考虑key下面没有任何东西的情况
        return list(d.values())

