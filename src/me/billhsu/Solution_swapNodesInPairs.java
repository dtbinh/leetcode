package me.billhsu;

/**
 * Created by Shipeng Xu on 2/19/15.
 * https://oj.leetcode.com/problems/swap-nodes-in-pairs/
 */
public class Solution_swapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode nextNode = head;
        int counter = 0;
        while(nextNode!=null) {
            if(counter%2==0) {
                swapNodes(nextNode, nextNode.next);
            }
            ++counter;
            nextNode = nextNode.next;
        }
        return head;
    }
    private void swapNodes(ListNode l1, ListNode l2) {
        if(l2 == null) return;
        int tmp = l2.val;
        l2.val = l1.val;
        l1.val = tmp;
    }
}
