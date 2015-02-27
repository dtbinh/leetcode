package me.billhsu;

/**
 * Created by Shipeng Xu on 2/27/15.
 * https://oj.leetcode.com/problems/n-queens-ii/
 */
public class Solution_nQueensII {
    int count = 0;
    public int totalNQueens(int n) {
        count = 0;
        solve(new boolean[n][n], 0, n);
        return count;
    }
    private boolean solve(boolean[][] board, int col, int n) {
        if(col == n) {
            count++;
            return true;
        }
        for(int i=0; i<n; ++i) {
            board[i][col] = true;
            if(isValid(board, i, col, n)) {
                solve(board, col+1, n);
            }
            board[i][col] = false;
        }
        return true;
    }
    private boolean isValid(boolean[][] board, int row, int col, int n) {
        for(int i=0; i<col; ++i) {
            if(board[row][i] != false) {
                return false;
            }
        }
        for(int i=row - 1,j=col - 1; i>=0 && j>=0; i--, j--) {
            if(board[i][j] != false) {
                return false;
            }
        }
        for(int i=row + 1,j=col - 1; i<n && j>=0; i++, j--) {
            if(board[i][j] != false) {
                return false;
            }
        }
        return true;
    }
}
