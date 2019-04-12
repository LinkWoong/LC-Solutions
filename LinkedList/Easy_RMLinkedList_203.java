package Leetcode;
/*
    Remove all elements from a linked list of integers that have value val.

    Example:

    Input:  1->2->6->3->4->5->6, val = 6
    Output: 1->2->3->4->5

*/

public class Easy_RMLinkedList_203 {
    // 思路：由于是剔除所有符合要求的element，就要重新构造一条链表
    // 弄一个dummyHead，并让其next指向head，再用current遍历剔除元素
    // 如果current.val == val，就跳过这个元素，跳过的实现是让prev（另一条链表）next指向current.next
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        //删除中间&末尾符合条件的node
        ListNode prev = dummyHead;
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }
            else{
                prev = prev.next;
            }
        }
        return head;
    }

    public ListNode removeElements_v2(ListNode head, int val){
        if(head == null)
            return null;

        head.next = removeElements_v2(head.next, val);
        return head.val == val ? head.next : head;
    }

    public ListNode removeElements_v3(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode current = head, prev = newHead;
        while(current != null){
            if(current.val == val){
                prev.next = current.next;
            } else{
                prev = prev.next;
            }
            current = current.next;
        }
        return newHead.next;
    }
}