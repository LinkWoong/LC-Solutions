
# coding: utf-8

# In[1]:


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
#注意：这道题只是让我们将两个链表A,B从头到尾,依照A[n],B[n]的大小决定谁在前,最后连接成一个形入A[0]B[0]B[1]A[1]B[1]A[1]A[2]B[2]。。。的链表
#并不是要把两个lists里的所有nodes都sort一遍再返回
#算法思路：
#step1:写一个recursive的方程，输入为两个链表，输出为两个链表value较小的那个head
#step2:在这个recursive方程中，将去掉这个较小head的pointer的两个链表作为这个recursive输入的方程返回的结果assign给较小head的pointer
#实现最初的两个链表链接在一起
class Solution:
    def mergeTwoLists(self, l1, l2):
        if not l1 or not l2:
            return l1 or l2
        if l1.val < l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2
        

