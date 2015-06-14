package me.billhsu;

/**
 * Created by Shipeng Xu on 13/6/15.
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class Solution_largestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        int maxArea = 0;
        for (int i=0; i<height.length; ++i) {
            if( i+1 < height.length && height[i+1] >= height[i])
                continue;
            int currentMax = height[i];
            int currentMinHeight = height[i];
            for(int j=i-1; j>=0; --j) {
                if(currentMinHeight>height[j]) currentMinHeight = height[j];
                int currentArea = (i-j + 1) * currentMinHeight;
                if(currentArea>currentMax) currentMax = currentArea;
            }
            if(currentMax>maxArea) maxArea = currentMax;
        }
        return maxArea;
    }
}
