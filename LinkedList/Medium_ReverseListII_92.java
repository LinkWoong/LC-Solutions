package Leetcode;
/*
    Reverse a linked list from position m to n. Do it in one-pass.

    Note: 1 ≤ m ≤ n ≤ length of list.

    Example:

    Input: 1->2->3->4->5->NULL, m = 2, n = 4
    Output: 1->4->3->2->5->NULL

 */
public class Medium_ReverseListII_92 {
    // 思路：首先找到m对应的node，再交换其后的node
    // 注意用prev保存m前一位的node
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null){
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;

        for(int i = 0; i < m - 1; i++){
            prev = prev.next;
        }

        ListNode p1 = prev.next;
        ListNode p2 = p1.next;

        for(int i = 0; i < n - m; i++){
            p1.next = p2.next;
            p2.next = prev.next;
            prev.next = p2;
            p2 = p1.next;
        }
        return dummyHead.next;
    }
}
