
# coding: utf-8

# In[5]:


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
#算法思路：运用recursive函数
#Step1:从链表的头开始遍历，知道找到最后一个没有pointer没有指向任何东西的节点
#Step2:从底开始向前遍历，设i=0,向前一次i+=1
#Step3:反向遍历到i+1=n的时候，遇到我们要删除的node，这个是时候跳过这个node，将上一个的pointer和下一个node相连
#Step4:最后实现跳过想要删去的node,反向重新连接了一次链表
class Solution:
    def remove(self, head, n):
            if not head:
                return 0, head
            i, head.next = self.remove(head.next,n)#反向连接
            return i+1, (head, head.next)[i+1 == n]
        
    def removeNthFromEnd(self, head, n):
        return self.remove(head, n)[1]
        
        

