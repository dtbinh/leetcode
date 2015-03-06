package me.billhsu;

/**
 * Created by Shipeng Xu on 5/3/15.
 */
public class Solution_uniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1 || obstacleGrid[0][0]==1) return 0;
        int[][] DP = new int[m][n];
        DP[m-1][n-1] = 1;
        for(int i=n-2; i>=0; --i) {
            if(obstacleGrid[m-1][i]==1) DP[m-1][i] = 0;
            else DP[m-1][i] = DP[m-1][i+1];
        }
        for(int i=m-2; i>=0; --i) {
            if(obstacleGrid[i][n-1]==1) DP[i][n-1] = 0;
            else DP[i][n-1] = DP[i+1][n-1];
        }
        for(int i=m-2; i>=0; --i) {
            for (int j=n-2; j>=0; --j) {
                if(obstacleGrid[i+1][j]==0 && obstacleGrid[i][j+1]==0) DP[i][j] = DP[i+1][j] + DP[i][j+1];
                else if(obstacleGrid[i+1][j]==1 && obstacleGrid[i][j+1]==0) DP[i][j] = DP[i][j+1];
                else if(obstacleGrid[i][j+1]==1 && obstacleGrid[i+1][j]==0) DP[i][j] = DP[i+1][j];
                else DP[i][j] = 0;
            }
        }
        return DP[0][0];
    }
}
