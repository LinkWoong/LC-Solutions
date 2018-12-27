package LeetCode;



import java.util.Comparator;
import java.util.PriorityQueue;

public class Hard_MergeKSortedLists_23_LMY {
    /*
        Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

    Example:

    Input:
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    Output: 1->1->2->3->4->4->5->6

     */


}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution1{
    //使用归并排序
    /*
    这道题目在分布式系统中非常常见，来自不同client的sorted list要在central server上面merge起来。这个题目一般有两种做法，下面一一介绍并且分析复杂度。 第一种做法比较容易想到，就是有点类似于MergeSort的思路,就是分治法，不了解MergeSort的朋友，请参见归并排序-维基百科，是一个比较经典的O(nlogn)的排序算法，还是比较重要的。思路是先分成两个子任务，然后递归求子任务，最后回溯回来。
    这个题目也是这样，先把k个list分成两半，然后继续划分，知道剩下两个list就合并起来，合并时会用到Merge Two Sorted Lists这道题，不熟悉的朋友可以复习一下。代码如下： 

     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        return helper(lists,0,lists.length - 1);
    }
    private ListNode helper(ListNode[] lists,int l, int r){
        if(l < r){
            int m = (l + r) / 2;
            return merge(helper(lists,l,m),helper(lists,m+1,r));
        }
        return lists[l];
    }
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode cur = dummy;
        while(l1 != null && l2!= null){
            if(l1.val<l2.val){
                l1 = l1.next;
            }else{
                ListNode next = l2.next;
                cur.next = l2;
                l2.next = l1;
                l2 = next;
            }
            cur = cur.next;
        }
        if(l2 != null)
            cur.next = l2;

        return dummy.next;
    }
}



class Solution2{
    /*
    接下来我们来看第二种方法。这种方法用到了堆的数据结构，思路比较难想到，但是其实原理比较简单。维护一个大小为k的堆，每次取堆顶的最小元素放到结果中，然后读取该元素的下一个元素放入堆中，重新维护好。
    因为每个链表是有序的，每次又是去当前k个元素中最小的，所以当所有链表都读完时结束，这个时候所有元素按从小到大放在结果链表中。这个算法每个元素要读取一次，即是k*n次，然后每次读取元素要把新元素插入堆中要logk的复杂度，所以总时间复杂度是O(nklogk)。空间复杂度是堆的大小，即为O(k)。代码如下：

     */


    public ListNode mergeKLists(ListNode[] lists){

        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(10,new Comparator<ListNode>(){

            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for(int i = 0 ; i < lists.length;i++){
            ListNode node = lists[i];
            if(node!=null){
                heap.offer(node);
            }
        }

        ListNode head = null;
        ListNode pre = head;
        while (heap.size() > 0) {
            ListNode cur = heap.poll();
            if(head == null){
                head = cur;
                pre = head;
            }else{
                pre.next = cur;
            }
            pre = cur;
            if(cur.next != null)
                heap.offer(cur.next);
            }
            return head;
        }
}

