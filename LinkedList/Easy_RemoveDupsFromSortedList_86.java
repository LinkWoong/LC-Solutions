package Leetcode;
/*
    Given a sorted linked list, delete all duplicates such that each element appear only once.

    Example 1:

    Input: 1->1->2
    Output: 1->2
    Example 2:

    Input: 1->1->2->3->3
    Output: 1->2->3
 */
public class Easy_RemoveDupsFromSortedList_86 {
    // 思路：重点在对ListNode current = head的理解上
    // 只是创建了一个head的alias，current动的时候head不变
    // current和head公用一个链表，head永远指着第一个，current向后移动按条件筛选。
    // 不用考虑链接的问题
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode current = head;
        while(current != null){
            if(current.next == null){
                break;
            }
            ListNode next = current.next;
            if(next.val == current.val){
                current.next = current.next.next;
            } else{
                current = current.next;
            }
        }
        return head;
    }
}
