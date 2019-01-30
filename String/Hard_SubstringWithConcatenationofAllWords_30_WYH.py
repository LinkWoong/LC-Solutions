
# coding: utf-8

# In[24]:


class Solution:
#算法思路：
#利用所有word的长度都是一样的这一点
#我们对要求的word进行字典化，key为word中的词，value为对应词在word中出现的次数
#利用这个字典，和s的长度，词的长度n，target的长度，对s进行遍历
#遍历的算法，以i为indice的s作为起点开始查词，为了包含所有情况，i应该等于1:n
#很重要的是我们要订下一个查词，起点l和终点r
#在查词的过程中新建另外一个字典，遇到了word字典里的词，也向这个字典里加入
#这个字典出现某次的次数，必须小于或者等于word字典里出现这个词的次数，如果超了，就将起点往后移，并使这个词的次数减一
#在满足之前的情况下，再触发r-l等于target长度的条件，则说明查到target了，返回起点l
    def findSubstring(self, s, words):
        if not s or not words:
            return []
        n = len(s)
        k = len(words[0])
        t = len(words) * k
        req = {}
        for w in words:
            req[w] = req[w] + 1 if w in req else 1
        ans = []
        for i in range(k):
            self._findSubstring(i, i, n, k, t, s, req, ans)
        return ans
 
    def _findSubstring(self, l, r, n, k, t, s, req, ans):
        curr = {}
        while r + k <= n:
            w = s[r:r + k]
            r += k
            if w not in req:
                l = r  
                curr.clear()
            else:
                curr[w] = curr[w] + 1 if w in curr else 1
                while curr[w] > req[w]:
                    curr[s[l:l + k]] -= 1
                    l += k
                if r - l == t:
                    ans.append(l)

