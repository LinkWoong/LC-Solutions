
# coding: utf-8

# In[ ]:


#算法思路：找到新的head和tail，将旧的尾和旧的头连上

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def rotateRight(self, head, k):
        if not head:    #cornor case1:无头
            return None
        
        if not head.next:#cornor case2:独头
            return head
        
        length = 0
        pointer1 = head
        while(pointer1.next):
            length += 1
            pointer1 = pointer1.next
        
        length += 1
        newtail = head
        newhead = None
        
        if not k%length:#cornor case3:头尾不变,如果不单独谈论则执行下面代码会出错,因为原link list的头尾并没有相连
            return head
       
        for i in range(length-k%length-1):
            newtail = newtail.next
        
        newhead = newtail.next
        pointer1.next = head
        newtail.next = None
        
        return newhead

