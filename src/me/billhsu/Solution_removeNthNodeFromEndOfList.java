package me.billhsu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shipeng Xu on 2/18/15.
 */

public class Solution_removeNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nextNode = head.next;
        List<ListNode> list = new ArrayList<ListNode>();
        list.add(head);
        while(nextNode!=null) {
            list.add(nextNode);
            nextNode = nextNode.next;
        }
        if(list.size()>=n+1) {
            list.get(list.size() - n - 1).next = list.get(list.size() - n).next;
        } else {
            return list.get(list.size() - n).next;
        }
        return head;
    }
}
