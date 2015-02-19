package me.billhsu;

/**
 * Created by Shipeng Xu on 2/19/15.
 * https://oj.leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class Solution_reverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode nextNode = head;
        while(nextNode!=null) {
            ListNode[] list = new ListNode[k];
            boolean dontSwap = false;
            for(int i=0; i<k; ++i) {
                if(nextNode == null) {
                    dontSwap = true;
                    break;
                }
                list[i] = nextNode;
                nextNode = nextNode.next;
            }
            if(!dontSwap) {
                swapNodes(list, k);
            }
        }
        return head;
    }
    private void swapNodes(ListNode[] l, int k) {
        for(int i=0; i<k/2; ++i) {
            swapNodes(l[i], l[k - i - 1]);
        }
    }
    private void swapNodes(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return;
        int tmp = l2.val;
        l2.val = l1.val;
        l1.val = tmp;
    }
}
