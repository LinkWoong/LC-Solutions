package Leetcode;
/*
    Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

    Example 1:

    Input: 1->2->3->3->4->4->5
    Output: 1->2->5
    Example 2:

    Input: 1->1->1->2->3
    Output: 2->3
 */
public class Medium_RemoveDupsFromSortedListII_82 {
    // 思路：要求不保留重复元素，所以如果遇到重复元素就跳过
    // 注意prev.next == current的比较是比较地址，不是比较val和其后面的node是否一样
    // 如果prev.next == current说明prev和current连在一起没有dups，否则就跳过current直接指向current.next
    public ListNode deleteDuplicates(ListNode head){
        if(head == null){
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode current = head;

        while(current != null){
            while(current.next != null && current.val == current.next.val){
                current = current.next;
            }
            if(prev.next == current){
                prev = prev.next;
            } else {
                prev.next = current.next;
            }
            current = current.next;
        }
        return dummyHead.next;
    }
}
