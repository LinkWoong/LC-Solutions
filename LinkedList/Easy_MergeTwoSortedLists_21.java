package Leetcode;
/*
    Merge two sorted linked lists and return it as a new list.
    The new list should be made by splicing together the nodes of the first two lists.

    Example:

    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4
 */
public class Easy_MergeTwoSortedLists_21 {
    // 思路：比较两个list各个元素大小，把小的链到新的dummyHead后面
    // 然后对应的list移动一位，注意一个链表到头而另一个没到的边界情况
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode head = dummyHead;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                head.next = l2;
                l2 = l2.next;
            } else {
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }
        while(l1 != null){
            head.next = l1;
            l1 = l1.next;
            head = head.next;
        }

        while(l2 != null){
            head.next = l2;
            l2 = l2.next;
            head = head.next;
        }
        return dummyHead.next;
    }
}
