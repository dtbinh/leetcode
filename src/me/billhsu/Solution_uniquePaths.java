package me.billhsu;

/**
 * Created by Shipeng Xu on 5/3/15.
 * https://oj.leetcode.com/problems/unique-paths/
 */
    public class Solution_uniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] DP = new int[m][n];
        DP[m-1][n-1] = 1;
        for(int i=n-2; i>=0; --i) {
            DP[m-1][i] = 1;
        }
        for(int i=m-2; i>=0; --i) {
            DP[i][n-1] = 1;
        }
        for(int i=m-2; i>=0; --i) {
            for (int j=n-2; j>=0; --j) {
                DP[i][j] = DP[i+1][j] + DP[i][j+1];
            }
        }
        return DP[0][0];
    }
}