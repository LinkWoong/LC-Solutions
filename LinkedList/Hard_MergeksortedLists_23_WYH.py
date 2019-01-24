
# coding: utf-8

# In[7]:


## If two elements have the same val, the next tuple items will be compared:
## "i" in the below code, which is guaranteed to be unique. 
#算法思路：
#将三个链表堆化，将node的value作为优先度
#新建一个链表dummmy
#对三个链表进行遍历，每次返回堆根的node的pointer，以此让dummy链接上这个node
#当一个链表被遍历完时，用heappop（）抛弃这个链表
#遍历中，每次找出node后，用heapreplace（），将堆中本次找出node的那个链表更新为它的下一个node
from heapq import heappush, heappop, heapreplace, heapify
class Solution:
    def mergeKLists(self, lists):
        heap = [(head.val, i, head) for i,head in enumerate(lists) if head]
        heapify(heap)
        dummy = ListNode(0)
        curr = dummy
        while heap != []:
            val, i, node = heap[0]
            if not node.next: # exhausted one linked-list
                heappop(heap)
            else:
                heapreplace(heap, (node.next.val, i, node.next)) # recycling tie-breaker i guarantees uniqueness
            curr.next = node    
            curr = curr.next
        return dummy.next

