package Leetcode;
/*
    Given a linked list, remove the n-th node from the end of list and return its head.
    Example:

    Given linked list: 1->2->3->4->5, and n = 2.

    After removing the second node from the end, the linked list becomes 1->2->3->5.

    Note:

    Given n will always be valid.

    Follow up:

    Could you do this in one pass?
 */
public class Medium_RemoveNthNodeFromTheEnd_19 {
    // 思路：从dummyHead开始，维护两个指针p1p2。
    // 此时p1不动，先将p2指针移到倒数第n+1个元素（注意是从1开始的）
    // 再共同维护两个指针直到p2移到链表末尾null，此时p1的位置是倒数第n+1个元素，跳过第n个元素（删除）
    // 返回之前设置的dummyHead即可
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode p1 = start, p2 = start;
        p1.next = head;

        for(int i = 1; i <= n+1; i++)
            p2 = p2.next;

        while (p2 != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        p1.next = p1.next.next;
        return start.next;
    }
}
