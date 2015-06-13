package me.billhsu;

/**
 * Created by Shipeng Xu on 13/6/15.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class Solution_Solution_removeDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode originHead = head;
        int oldVal = head.val;
        ListNode dummyNode = null;
        ListNode lastNode = null;
        while (head != null && head.next != null) {
            if (head.next.val == oldVal) {
                dummyNode = head;
                head.next = head.next.next;
            } else {
                if(dummyNode != null) {
                    if(lastNode == null) {
                        originHead = dummyNode.next;
                    }
                    else lastNode.next = dummyNode.next;
                    head = dummyNode.next;
                    dummyNode = null;
                } else {
                    lastNode = head;
                    head = head.next;
                }
                oldVal = head.val;
            }
        }
        if(dummyNode!=null && originHead==dummyNode) return null;
        if(dummyNode!=null) lastNode.next = null;
        return originHead;
    }
}
