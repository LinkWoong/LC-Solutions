
# coding: utf-8

# In[ ]:


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
#算法思路：
#从左往右，依次将链表的每个pair调换顺序，stride为2
#为此，我们需要设计一个浮标，这是一个node，我们每次都调换当次浮标下一对node的位置，然后再使浮标向后移动两个node
#step1:判断是否存在下一对node
#step2:做出三次链表的重连
#（1）第一个node链接第三个node
#（2）第二个node链接第一个node
#（3）第一个node成为浮标
#注意：将self作为了第一个浮标
class Solution:
    def swapPairs(self, head):
        pre, pre.next = self, head
        while pre.next and pre.next.next:
            a = pre.next
            b = a.next
            pre.next, b.next, a.next = b, a, b.next
            pre = a
        return self.next
        

