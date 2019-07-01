package Leetcode;
/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class Medium_ReorderList_143 {
    // 思路：快慢指针找到队尾和middle前一个node，先把middle到队尾全部nodes reverse
    // 再从前半部分开始一个一个链接
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode p1 = head, p2 = head;
        while(p1.next != null && p1.next.next != null){
            p1 = p1.next.next;
            p2 = p2.next;
        }

        ListNode preMiddle = p2;
        ListNode preCurrent = p2.next;

        while(preCurrent.next != null){
            ListNode next = preCurrent.next;
            preCurrent.next = next.next;
            next.next = preMiddle.next;
            preMiddle.next = next;
        }

        p1 = head;
        p2 = preMiddle.next;
        while(p1 != preMiddle){
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMiddle.next;
        }
    }
}
