package me.billhsu;

/**
 * Created by Shipeng Xu on 2/22/15.
 * https://oj.leetcode.com/problems/valid-sudoku/
 */
public class Solution_validSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; ++i) {
            int[] numbers_x = new int[9];
            int[] numbers_y = new int[9];
            for(int j=0; j<9; ++j) {
                if(board[i][j]!='.') {
                    int key = board[i][j] - 48 -1;
                    if(numbers_x[key] == 0) {
                        numbers_x[key] = 1;
                    } else {
                        return false;
                    }
                }
                if(board[j][i]!='.') {
                    int key = board[j][i] - 48 -1;
                    if(numbers_y[key] == 0) {
                        numbers_y[key] = 1;
                    } else {
                        return false;
                    }
                }
            }
        }
        int[] firstSubCellX = {0,3,6,0,3,6,0,3,6};
        int[] firstSubCellY = {0,0,0,3,3,3,6,6,6};
        for(int i=0; i<9; ++i) {
            int[] numbers = new int[9];
            int x = firstSubCellX[i];
            int y = firstSubCellY[i];
            for(int j=0; j<9; ++j) {
                int currX=x+j%3;
                int currY=y+j/3;
                if(board[currX][currY]!='.') {
                    int key = board[currX][currY] - 48 -1;
                    if(numbers[key] == 0) {
                        numbers[key] = 1;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
