package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    Given a singly linked list, determine if it is a palindrome.

    Example 1:

    Input: 1->2
    Output: false
    Example 2:

    Input: 1->2->2->1
    Output: true
    Follow up:
    Could you do it in O(n) time and O(1) space?
 */
public class Easy_PalindromeLinkedList_234 {
    // 思路：遍历两次，第一次遍历是从前往后把每个元素放到list中
    // 并且reverse当前node
    // 第二次遍历是从后往前，查看当前元素是否与list中get到的元素相同
    // Time: o(n), space: o(1)
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        ListNode prev = null;
        ListNode current = head;
        List<Integer> list = new ArrayList<>();
        list.add(head.val);
        int p = 0;

        while(current != null){
            ListNode next = current.next;
            if(next != null)
                list.add(next.val);
            current.next = prev;
            prev = current;
            current = next;
        }

        while(prev != null){
            if(prev.val != list.get(p))
                return false;
            prev = prev.next;
            p++;
        }

        return true;
    }

    // 第二种思路：从中间将链表断开并reverse第二段
    // 从第二段末开始比较第二段和剩余的head部分每个node的值
    // 注意奇偶情况（多加一次fast的判断即可）
    // Time: o(n), space: o(1)
    public boolean isPalindrome_v2(ListNode head){
        if(head == null){
            return true;
        }
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null){
            slow = slow.next;
        }

        slow = reverseList(slow);
        fast = head;

        while(slow != null){
            if(fast.val != slow.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head){

        ListNode prev = null;
        ListNode current = head;

        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
