package me.billhsu;

/**
 * Created by Shipeng Xu on 28/6/15.
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class Solution_reverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        int currentPos = 1;
        ListNode preReverseStart = dummy;
        ListNode preDummy = new ListNode(0);
        preDummy.next = dummy;
        ListNode preCurrent = preDummy;
        while (current != null) {
            ListNode originCurrentNext = current.next;
            if (currentPos == m) {
                preReverseStart = current;
            }
            if (currentPos > m + 1) {
                preCurrent.next = current.next;
                current.next = preReverseStart.next;
                preReverseStart.next = current;
                if (currentPos > n) break;
            } else {
                preCurrent = current;
            }
            current = originCurrentNext;
            currentPos++;
        }

        return dummy.next;
    }
}
