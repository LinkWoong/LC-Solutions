
# coding: utf-8

# In[ ]:


class Solution:
    # @param a list of integers
    # @return an integer
#算法思路：
#step1:创建两个indices,一个read,一个write，分别开始遍历整个array
#step2:read和write的遍历方式不一样，write遇到replicate会停下，read不会停下
#step3:write如果停下，那么它要等到read将replicate的部分走完了，它才能前进
#step4:如果前后没有duplicate，A[write]=A[read]
    def removeDuplicates(self, A):
        if not A:
            return 0
        end = len(A)
        read = 1
        write = 1
        while read < end:
            if A[read] != A[read-1]:
                A[write] = A[read]
                write += 1
            read += 1
        return write
#注意！！！：题目要求不能建立任何新的space，这里的解法只在原来的array A上操作，但我并不确定这个解法是否占用了新的memory

