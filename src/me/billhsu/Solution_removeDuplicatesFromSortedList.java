package me.billhsu;

/**
 * Created by Shipeng Xu on 13/6/15.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class Solution_removeDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode originHead = head;
        int oldVal = head.val;
        while (head != null && head.next != null) {
            if (head.next.val == oldVal) {
                head.next = head.next.next;
            } else {
                head = head.next;
                oldVal = head.val;
            }
        }
        return originHead;
    }
}
