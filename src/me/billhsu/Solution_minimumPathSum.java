package me.billhsu;

/**
 * Created by Shipeng Xu on 15/3/15.
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class Solution_minimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid==null) return 0;
        if (grid.length == 0) return 0;
        if(grid[0].length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int [][]DP = new int [n][m];
        DP[n-1][m-1] = grid[n-1][m-1];
        for (int i = m - 2; i >= 0; --i) {
            DP[n-1][i] = DP[n-1][i+1] + grid[n-1][i];
        }
        for (int i = n - 2; i >= 0; --i) {
            DP[i][m-1] = DP[i+1][m-1] + grid[i][m-1];
        }
        for (int i = n - 2; i >= 0; --i) {
            for(int j = m - 2; j >= 0; --j) {
                DP[i][j] = Math.min(DP[i+1][j], DP[i][j+1]) + grid[i][j];
            }
        }
        return DP[0][0];
    }
}
