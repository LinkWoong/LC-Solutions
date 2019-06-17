package Leetcode;
/*
    Given a linked list, rotate the list to the right by k places, where k is non-negative.

    Example 1:

    Input: 1->2->3->4->5->NULL, k = 2
    Output: 4->5->1->2->3->NULL
    Explanation:
    rotate 1 steps to the right: 5->1->2->3->4->NULL
    rotate 2 steps to the right: 4->5->1->2->3->NULL
    Example 2:

    Input: 0->1->2->NULL, k = 4
    Output: 2->0->1->NULL
    Explanation:
    rotate 1 steps to the right: 2->0->1->NULL
    rotate 2 steps to the right: 1->2->0->NULL
    rotate 3 steps to the right: 0->1->2->NULL
    rotate 4 steps to the right: 2->0->1->NULL
 */
public class Medium_RotateList_61 {
    // 思路：题目很有意思，类比以前做过的Rotate Array计算需要移动的步长step
    // 首先找到list长度，再形成一个cycle list闭环current.next = head
    // 最后再找到断开的点就行了
    // 注意一定要head.next = null否则会内存溢出（形成闭环链表）
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        int length = 1;
        ListNode current = head;
        while(current.next != null){
            current = current.next;
            length++;
        }
        current.next = head;
        int newHead = length - 1 - k % length;
        for(int i = 0; i < newHead; i++){
            head = head.next;
        }
        ListNode next = head.next;
        head.next = null;
        return next;
    }
}
