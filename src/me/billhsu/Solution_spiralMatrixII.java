package me.billhsu;

/**
 * Created by Shipeng Xu on 2/28/15.
 * https://oj.leetcode.com/problems/spiral-matrix-ii/
 */
public class Solution_spiralMatrixII {
    public int[][] generateMatrix(int n) {
        int rows = n;
        int cols = n;
        boolean[][] visited = new boolean[rows][cols];
        int circleCnt = 0;
        int state = 0;
        int nextRow = 0, nextCol = 0;
        int count = 0;
        int[][] result = new int[n][n];
        while(nextRow<rows && nextCol<cols && nextRow>=0 && nextCol>=0 && !visited[nextRow][nextCol]) {
            visited[nextRow][nextCol] = true;
            result[nextRow][nextCol] = count+1;
            ++count;
            if(state == 0) {
                if(nextCol<cols - circleCnt - 1) ++nextCol;
                else {
                    ++nextRow;
                    state = 1;
                }
            } else if (state == 1) {
                if(nextRow<rows - circleCnt - 1) ++nextRow;
                else {
                    --nextCol;
                    state = 2;
                }
            } else if (state == 2) {
                if(nextCol>circleCnt) --nextCol;
                else {
                    --nextRow;
                    state = 3;
                }
            } else if (state == 3) {
                if(nextRow>circleCnt+1) --nextRow;
                else {
                    ++nextCol;
                    ++circleCnt;
                    state = 0;
                }
            }
        }
        return result;
    }
}
