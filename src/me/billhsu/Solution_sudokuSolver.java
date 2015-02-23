package me.billhsu;

/**
 * Created by Shipeng Xu on 2/23/15.
 * https://oj.leetcode.com/problems/sudoku-solver/
 */
public class Solution_sudokuSolver {
    public void solveSudoku(char[][] board) {
        fillSudoku(board, 0, 0);
    }
    private boolean fillSudoku(char[][] board, int row, int col) {
        if(row==9) return true;
        int nextCol, nextRow;
        if(col == 8) {
            nextCol = 0;
            nextRow = row + 1;
        } else {
            nextCol = col + 1;
            nextRow = row;
        }
        if(board[row][col] != '.') {
            if(isVaild(board, row, col)) {
                return fillSudoku(board, nextRow, nextCol);
            } else {
                return false;
            }
        } else {
            for(int i=1; i<=9; ++i) {
                char valAscii = (char)('0' + i);
                board[row][col] = valAscii;
                if(isVaild(board, row, col)) {
                    if(fillSudoku(board, nextRow, nextCol)) {
                        return true;
                    }
                }
                board[row][col] = '.';
            }
        }
        return false;
    }
    private boolean isVaild(char[][] board, int row, int col) {
        for(int i = 0; i < 9; ++i) {
            if(board[i][col] == board[row][col] && i != row) return false;
            if(board[row][i] == board[row][col] && i != col) return false;
        }
        for(int i=row/3*3; i<row/3*3 + 3; ++i) {
            for(int j=col/3*3; j<col/3*3 + 3; ++j) {
                if(board[i][j] == board[row][col] && (i!=row || j!=col)) return false;
            }
        }
        return true;
    }
}
