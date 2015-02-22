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

        Solution_validSudoku solution = new Solution_validSudoku();
        char[][] input = {".87654321".toCharArray(),"2........".toCharArray(),"3........".toCharArray(),
                "4........".toCharArray(),"5........".toCharArray(),"6........".toCharArray(),
                "7........".toCharArray(),"8........".toCharArray(),"9........".toCharArray()};
        System.out.println(solution.isValidSudoku(input));
    }
}
