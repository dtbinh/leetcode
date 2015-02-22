package me.billhsu;

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

        Solution_searchForARange solution = new Solution_searchForARange();
        int[] input = {0,1,2,2,3,4,5,6,7};
        System.out.println(solution.searchRange(input, 2));
    }
}
