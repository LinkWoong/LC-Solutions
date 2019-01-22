
# coding: utf-8

# In[ ]:


class Solution:
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
#算法思路：
#step1:得到string和target的长度
#step2:如果target为空“”，那么视为它的位置就在string最前面，返回0
#step3:如果target的长度大于了string的长度，那么不可能找到它，返回-1
#step4:其他情况下遍历string (string[i:i+len(target)] == target),满足条件则返回i
#step5:在step4中的情况下，遍历到最后都没有找到，则返回-1
        needlen = len(needle)
        hayslen = len(haystack)
        if needlen == 0:
            return 0
        elif needlen > hayslen:
            return -1
        else:
            i = 0
            while i + needlen <= hayslen:
                if haystack[i:i+needlen] == needle:
                    return i
                else:
                    i = i + 1
            return -1

