package me.billhsu;

/**
 * Created by Shipeng Xu on 17/3/15.
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
public class Solution_setMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return;
        int m = matrix[0].length;
        boolean row1zero = false;
        boolean col1zero = false;
        for(int i=0; i<n; ++i) {
            for(int j=0; j<m; ++j) {
                if(matrix[i][j]==0) {
                    if(i == 0) row1zero = true;
                    if(j ==0 ) col1zero = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i=1; i<n; ++i) {
            for (int j = 1; j < m; ++j) {
                if(matrix[0][j]==0 || matrix[i][0]==0) matrix[i][j] = 0;
            }
        }
        if(row1zero) {
            for(int i=0; i<m; ++i) {
                matrix[0][i] = 0;
            }
        }
        if(col1zero) {
            for(int i=0; i<n; ++i) {
                matrix[i][0] = 0;
            }
        }
        return;
    }
}