package LeetCode;

public class Easy_LinkedListCycleII_142_LMY {

    /*
        Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

    To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

    Note: Do not modify the linked list.



    Example 1:

    Input: head = [3,2,0,-4], pos = 1
    Output: tail connects to node index 1
    Explanation: There is a cycle in the linked list, where tail connects to the second node.


    Example 2:

    Input: head = [1,2], pos = 0
    Output: tail connects to node index 0
    Explanation: There is a cycle in the linked list, where tail connects to the first node.


    Example 3:

    Input: head = [1], pos = -1
    Output: no cycle
    Explanation: There is no cycle in the linked list.
     */
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }
 /*注意：while循环的时候在循环内部判断两个指针相等，不要再循环条件中判断不等
    https://www.cnblogs.com/hiddenfox/p/3408931.html
  */
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;//遇到null了，说明不存在环
        ListNode slow = head;
        ListNode fast = head;
        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow)
                break;
        }
        if(fast == null || fast.next == null){
            return null;
        }
        slow = head;
        while(slow !=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
