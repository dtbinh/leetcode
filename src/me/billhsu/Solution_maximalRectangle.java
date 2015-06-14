package me.billhsu;

/**
 * Created by Shipeng Xu on 14/6/15.
 * https://leetcode.com/problems/maximal-rectangle/
 */
public class Solution_maximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m==0) return 0;
        int n = matrix[0].length;

        int maxArea = 0;
        int[][] heights = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i > 0) {
                    if (matrix[i][j] == '1') heights[i][j] = heights[i - 1][j] + 1;
                    else heights[i][j] = 0;
                } else {
                    heights[i][j] = (matrix[i][j]=='1'?1:0);
                }
            }
            int currentMax = largestRectangleArea(heights[i]);
            if(maxArea<currentMax) maxArea = currentMax;
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; ++i) {
            if (i + 1 < height.length && height[i + 1] >= height[i])
                continue;
            int currentMax = height[i];
            int currentMinHeight = height[i];
            for (int j = i - 1; j >= 0; --j) {
                if (currentMinHeight > height[j]) currentMinHeight = height[j];
                int currentArea = (i - j + 1) * currentMinHeight;
                if (currentArea > currentMax) currentMax = currentArea;
            }
            if (currentMax > maxArea) maxArea = currentMax;
        }
        return maxArea;
    }
}
