package Leetcode;
/*
    Given a linked list, swap every two adjacent nodes and return its head.

    You may not modify the values in the list's nodes, only nodes itself may be changed.



    Example:

    Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class Medium_SwapNodesinPairs_24 {
    // 思路：两个两个换，重点在于交换两个节点的逻辑：首先先将目前节点的下一个和下下个引用存起来
    // 再将目前节点的下个指向下下个节点(1->3)
    // 再将之前存起来的下一个指向目前节点(2->1)
    // 再让第二个节点成为首节点(2->1)
    // 最后让断掉的2,3节点连接起来node.next.next = helper(之前存的下下个引用)
    public ListNode swapPairs(ListNode head) {
        head = helper(head);
        return head;
    }

    private ListNode helper(ListNode node){
        if(node == null || node.next == null)
            return node;
        else
        {
            ListNode temp = node.next; // temp = 2
            ListNode nextNode = node.next.next;
            node.next = temp.next;
            temp.next = node;
            node = temp;
            node.next.next = helper(nextNode);
            return node;
        }
    }
}
