package me.billhsu;

/**
 * Created by Shipeng Xu on 2/26/15.
 * https://oj.leetcode.com/problems/jump-game-ii/
 */
public class Solution_jumpGameII {
    public int jump(int[] A) {
        if(A.length == 0) return 0;
        if(A.length == 1) return 0;
        int left = 0;
        int right = 0;
        int minHops = 0;
        while(right<A.length - 1) {
            minHops++;
            int newLeft = left;
            int newRight = right;
            for(int i=left; i<=right; ++i) {
                if(i+A[i]>newRight) {
                    newRight = i+A[i];
                    newLeft = i;
                }
            }
            left = newLeft;
            right = newRight;
        }
        return minHops;
    }
    // The following DP soluiton will give a time limit error
//    public int jump(int[] A) {
//        // DP[i] is min hops to A[i]
//        int[] DP = new int[A.length];
//        for(int i=0; i<A.length; ++i) {
//            int minHops = Integer.MAX_VALUE;
//            for(int j=i-1; j>=0; --j) {
//                if(A[j]+j>=i && DP[j] + 1<minHops) {
//                    minHops = DP[j] + 1;
//                }
//            }
//            if(minHops!=Integer.MAX_VALUE) DP[i] = minHops;
//        }
//        return DP[A.length-1];
//    }
}
