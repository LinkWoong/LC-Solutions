package Leetcode;
/*
    Write a program to find the node at which the intersection of two singly linked lists begins.

    For example, the following two linked lists:
    begin to intersect at node c1.

    Example 1:


    Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
    Output: Reference of the node with value = 8

    Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
    From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5].
    There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.

 */
public class Easy_IntersectionOfTwoLists_160 {
    // 思路：目的是找到两条链表汇合的第一个节点
    // 先找到两条链表的长度，再根据得到的长度对齐两个指针
    // 然后两个指针一起出发，当相等时返回即可
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode p1 = headA, p2 = headB;
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        while(lengthB > lengthA){
            p2 = p2.next;
            lengthB--;
        }

        while(lengthA > lengthB){
            p1 = p1.next;
            lengthA--;
        }

        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;

    }

    private int getLength(ListNode node){
        int res = 0;
        while(node != null){
            node = node.next;
            res++;
        }
        return res;
    }
}
