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

        Solution_sudokuSolver solution = new Solution_sudokuSolver();
        char[][] input = {"..9748...".toCharArray(),"7........".toCharArray(),".2.1.9...".toCharArray(),
                "..7...24.".toCharArray(),".64.1.59.".toCharArray(),".98...3..".toCharArray(),
                "...8.3.2.".toCharArray(),"........6".toCharArray(),"...2759..".toCharArray()};
        solution.solveSudoku(input);
        for(int i=0; i<9; ++i) {
            for(int j=-0; j<9; ++j) {
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
    }
}
