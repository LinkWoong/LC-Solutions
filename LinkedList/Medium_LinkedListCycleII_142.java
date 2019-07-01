package Leetcode;
/*
    Given a linked list, return the node where the cycle begins.
    If there is no cycle, return null.

    To represent a cycle in the given linked list,
    we use an integer pos which represents the position (0-indexed)
    in the linked list where tail connects to.
    If pos is -1, then there is no cycle in the linked list.

    Note: Do not modify the linked list.

    Example 1:

    Input: head = [3,2,0,-4], pos = 1
    Output: tail connects to node index 1
    Explanation: There is a cycle in the linked list, where tail connects to the second node.
 */
public class Medium_LinkedListCycleII_142 {
    // 思路：用双指针一个每次走一步，一个每次走两步。如果相遇则说明有cycle
    // 想一下可以推出从head到cycle开始的距离与相遇点到cycle开始的距离是相等的
    // 所以利用第三个指针从head开始走到快慢指针相遇的node，即为cycle的entrance
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode p1 = head, p2 = head;
        boolean flag = false;

        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                flag = true;
                break;
            }
        }

        if(!flag){
            return null;
        }

        ListNode p3 = head;
        while(p3 != p2){
            p3 = p3.next;
            p2 = p2.next;
        }
        return p3;
    }
}
