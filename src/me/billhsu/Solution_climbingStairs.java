package me.billhsu;

/**
 * Created by Shipeng Xu on 17/3/15.
 * https://leetcode.com/problems/climbing-stairs/
 */
public class Solution_climbingStairs {
    public int climbStairs(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        if (n==2) return 2;
        int[] result = new int[n];
        result[n-1] = 1;
        result[n-2] = 2;
        for (int i=n-3; i>=0; --i) {
            result[i] = result[i+1] + result[i+2];
        }
        return result[0];
    }
}
