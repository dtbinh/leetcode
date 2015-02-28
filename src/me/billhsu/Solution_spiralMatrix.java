package me.billhsu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shipeng Xu on 2/28/15.
 * https://oj.leetcode.com/problems/spiral-matrix/
 */
public class Solution_spiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int rows = matrix.length;
        if(rows==0) return result;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int circleCnt = 0;
        int state = 0;
        int nextRow = 0, nextCol = 0;
        while(nextRow<rows && nextCol<cols && nextRow>=0 && nextCol>=0 && !visited[nextRow][nextCol]) {
            visited[nextRow][nextCol] = true;
            result.add(matrix[nextRow][nextCol]);
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
