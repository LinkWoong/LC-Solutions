
# coding: utf-8

# In[1]:


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
#算法思路：按K的大小，把整个链表分为k*n+1段
#对前n个完整group进行reverse
#这里需要新定义一个head的head（即题目里的ret）
#reverse时，先调换首尾
#在将剩余的node，从左到右加到尾巴的左边
class Solution(object):
    def reverseKGroup(self, head, k):
        if not head or k == 1:#no nodes or no reverse
            return head

        ret = ListNode(0)
        ret.next = head
        head = ret#head is the zero node whose next is input head 
        tail = head
        
        
        while tail:
            for i in range(k):#find tail for current complete nodes
                tail = tail.next
                if not tail:#no complete k nodes here
                    return ret.next
                #0-123456-xxxxx
            else:
                pre = head.next#first node pointer -1
                cur = pre.next#second node pointer -2
                pre.next = tail.next#first node connect next first node(become last node) 1-xxxxxx
                head.next = tail#first node become last node 0-6-xxxxx
                head = pre#zero node become last node head= -1
                #0-6-xxxxx 2345-6-xxxxx 1-xxxxx
                
                
                while tail != cur:
                    cur.next, pre, cur = pre, cur, cur.next
                # 21-xxxxx 
                # 321-xxxxx
                # 4321-xxxxx
                # 54321-xxxxx
                
                cur.next = pre
                # 0-654321-xxxxx
                tail = head
                # tail = -1
        return ret.next # -6

