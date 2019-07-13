package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    Sort a linked list using insertion sort.

    A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
    With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list


    Algorithm of Insertion Sort:

    Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
    At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
    It repeats until no input elements remain.

    Example 1:

    Input: 4->2->1->3
    Output: 1->2->3->4
    Example 2:

    Input: -1->5->3->4->0
    Output: -1->0->3->4->5
 */
public class Medium_InsertionSortList_147 {
    // 思路：新起一个dummyHead，双指针一个扫描head，另一个扫描dummyHead
    // 当prev.next非空且比head的值要小，说明排序好了，跳过这个node
    // 如果大，把current插入到prev和prev.next中间，然后prev返回dummyHead
    // 还有第二种思路，先把head所有值提出来排好序，再一个一个链回去
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = head, prev = dummyHead;
        while(current != null){
            ListNode next = current.next;
            while(prev.next != null && prev.next.val < current.val){
                prev = prev.next;
            }
            current.next = prev.next;
            prev.next = current;
            current = next;
            prev = dummyHead;
        }
        return dummyHead.next;
    }

    public ListNode insertionSortList_v2(ListNode head){
        if(head == null){
            return null;
        }
        List<Integer> res = new ArrayList<>();
        while(head != null){
            res.add(head.val);
            head = head.next;
        }

        for(int i = 1; i < res.size(); i++){
            int key = res.get(i);
            int j = i - 1;

            while(j >= 0 && res.get(j) > key){
                res.set(j + 1, res.get(j));
                j--;
            }
            res.set(j + 1, key);
        }
        ListNode dummyHead = new ListNode(0);
        ListNode prev = dummyHead;
        for(Integer i: res){
            prev.next = new ListNode(i);
            prev = prev.next;
        }
        return dummyHead.next;
    }
}
