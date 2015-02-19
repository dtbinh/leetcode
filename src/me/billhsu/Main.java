package me.billhsu;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.next = l2;
        l3.next = l4;
        l5.next = l6;

        List<ListNode> list = new ArrayList<ListNode>();
        list.add(null);
//        list.add(l3);
//        list.add(l5);
        Solution_mergeKSortedLists solution = new Solution_mergeKSortedLists();
        System.out.println(solution.mergeKLists(list));
    }
}
