package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
    Reverse a singly linked list.

    Example:

    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL
    Follow up:

    A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class Easy_ReverseLinkedList_206 {
    // 思路：基本功
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        Queue<ListNode> queue = new LinkedList<>();
        while(head.next != null){
            queue.add(head);
            head = head.next;
        }
        while(!queue.isEmpty()){
            ListNode node = queue.remove();
            node.next = head.next;
            head.next = node;
        }
        return head;
    }
}
