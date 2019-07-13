package Leetcode;
/*
    Given a singly linked list, group all odd nodes together followed by the even nodes.
    Please note here we are talking about the node number and not the value in the nodes.

    You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

    Example 1:

    Input: 1->2->3->4->5->NULL
    Output: 1->3->5->2->4->NULL
    Example 2:

    Input: 2->1->3->5->6->4->7->NULL
    Output: 2->3->6->7->1->5->4->NULL
    Note:

    The relative order inside both the even and odd groups should remain as it was in the input.
    The first node is considered odd, the second node even and so on ...
 */
public class Medium_OddEvenLinkedList_328 {
    // 思路：和partition list思路一样，新弄两个head，一个存奇数节点另一个存偶数节点
    // 最后再把奇数节点尾巴连到偶数节点的head即可，别忘了给偶数节点头部做一个备份
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p1 = head, p2 = head.next, even = head.next;
        while(p1.next != null && p2.next != null){
            p1.next = p1.next.next;
            p2.next = p2.next.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        p1.next = even;
        return dummyHead.next;
    }
}
