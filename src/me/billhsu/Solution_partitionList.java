package me.billhsu;

/**
 * Created by Shipeng Xu on 14/6/15.
 * https://leetcode.com/problems/partition-list/
 */
public class Solution_partitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode p2Head = null;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode p2HeadOriginal = null;
        ListNode originHead = pre;
        while (head != null) {
            if (head.val < x) {
                pre = head;
                head = head.next;
            } else {
                if (p2Head == null) {
                    p2Head = head;
                    p2HeadOriginal = p2Head;
                } else {
                    p2Head.next = head;
                    p2Head = p2Head.next;
                }
                pre.next = head.next;
                head = head.next;
            }
        }
        if (p2Head != null) p2Head.next = null;
        if (p2HeadOriginal != null) pre.next = p2HeadOriginal;
        return originHead.next;
    }
}
