package Leetcode;
/*
    Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

    You should preserve the original relative order of the nodes in each of the two partitions.

    Example:

    Input: head = 1->4->3->2->5->2, x = 3
    Output: 1->2->2->4->3->5
 */
public class Medium_PartitionList_86 {
    // 思路：题目要求小于x的node排在链表最前面，并且保持其余顺序不变
    // 可以新建两条链表，一条记录小于x的node，另一条记录其余的node，最后再concat到一起
    // 同Rotate List，一定要手动p2.next = null防止内存溢出
    public ListNode partition(ListNode head, int x) {
        ListNode p1Head = new ListNode(0), p2Head = new ListNode(0);
        ListNode p1 = p1Head, p2 = p2Head;
        while(head != null){
            if(head.val < x){
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p1.next = p2Head.next;
        p2.next = null;
        return p1Head.next;
    }
}
