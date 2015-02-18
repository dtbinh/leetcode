package me.billhsu;

public class Main {

    public static void main(String[] args) {
        Solution_MergeTwoSortedLists solution = new Solution_MergeTwoSortedLists();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l3.next = l4;
        System.out.println(solution.mergeTwoLists(l1, l3));
    }
}
