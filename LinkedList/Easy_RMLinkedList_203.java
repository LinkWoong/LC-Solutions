package Leetcode;
/*
    Remove all elements from a linked list of integers that have value val.

    Example:

    Input:  1->2->6->3->4->5->6, val = 6
    Output: 1->2->3->4->5

*/

public class Easy_RMLinkedList_203 {

    public static void main(String[] args){

    }
    public ListNode removeElements(ListNode head, int val) {
        // 删除所有开始的符合条件的node
        ListNode dummyHead = new ListNode(-1);
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
}