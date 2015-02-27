package me.billhsu;

/**
 * Created by Shipeng Xu on 2/27/15.
 * https://oj.leetcode.com/problems/maximum-subarray/
 */
public class Solution_maximumSubarray {
    public int maxSubArray(int[] A) {
        int[] DP = new int[A.length];
        if(A.length == 0) return 0;
        if(A.length == 1) return A[0];
        DP[0] = A[0];
        int maxSum = DP[0];
        for(int i=1; i<A.length; ++i) {
            if(DP[i-1]+A[i]>A[i]) {
                DP[i] = DP[i-1]+A[i];
            } else {
                DP[i] = A[i];
            }
            if(DP[i]>maxSum) maxSum = DP[i];
        }
        return maxSum;
    }
}
