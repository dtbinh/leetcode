package me.billhsu;

import java.util.ArrayList;
import java.util.Arrays;
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
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(2,3));
        input.add(new Interval(4,5));
        input.add(new Interval(6,7));
        input.add(new Interval(8,9));
        input.add(new Interval(1,10));
        System.out.println(new Solution_mergeIntervals().merge(input));
    }
}
