package me.billhsu;

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
        int[] input = {1};
        List<List<Integer>> result = new Solution_combinationSum().combinationSum(input, 2);
        for(int i=0; i<result.size(); ++i) {
            for(int j=0; j<result.get(i).size(); ++j) {
                System.out.println(result.get(i).get(j));
            }
            System.out.println();
        }
    }
}
