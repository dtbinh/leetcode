package me.billhsu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shipeng Xu on 3/5/15.
 * https://oj.leetcode.com/problems/rotate-list/
 */
public class Solution_rotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if(head==null || n==0) return head;
        ListNode originHead = head;
        if (head.next ==null) return head;
        ListNode nextNode = head.next;
        List<ListNode> nodeList = new ArrayList<ListNode>();
        nodeList.add(head);
        while(nextNode!=null) {
            nodeList.add(nextNode);
            nextNode = nextNode.next;
        }

        n = n % nodeList.size();
        if(n==0) return head;
        ListNode newHead = nodeList.get(nodeList.size()-n);
        ListNode newEnd = nodeList.get(nodeList.size()-n-1);
        newEnd.next = null;
        nodeList.get(nodeList.size()-1).next = originHead;
        return newHead;
        
    }
}
