package me.billhsu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shipeng Xu on 2/23/15.
 * https://oj.leetcode.com/problems/n-queens/
 */
public class Solution_nQueens {
    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();
        char[][] board = new char[n][n];
        for(int i=0; i<n; ++i) {
            for(int j=0; j<n; ++j) {
                board[i][j] = '.';
            }
        }
        solve(board, 0, n, result);
        return result;
    }
    private boolean solve(char[][] board, int col, int n, List<String[]> result) {
        if(col == n) {
            String[] strs = new String[n];
            for(int i=0; i<n; ++i) {
                strs[i] = new String(board[i]);
            }
            result.add(strs);
            return true;
        }
        for(int i=0; i<n; ++i) {
            board[i][col] = 'Q';
            if(isValid(board, i, col, n)) {
                solve(board, col+1, n, result);
            }
            board[i][col] = '.';
        }
        return false;
    }
    private boolean isValid(char[][] board, int row, int col, int n) {
        for(int i=0; i<col; ++i) {
            if(board[row][i] != '.') {
                return false;
            }
        }
        for(int i=row - 1,j=col - 1; i>=0 && j>=0; i--, j--) {
            if(board[i][j] != '.') {
                return false;
            }
        }
        for(int i=row + 1,j=col - 1; i<n && j>=0; i++, j--) {
            if(board[i][j] != '.') {
                return false;
            }
        }
        return true;
    }
}
