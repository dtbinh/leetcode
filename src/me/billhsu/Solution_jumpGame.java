package me.billhsu;

/**
 * Created by Shipeng Xu on 2/28/15.
 * https://oj.leetcode.com/problems/jump-game/
 */
public class Solution_jumpGame {
    public boolean canJump(int[] A) {
        if (A.length ==0) return false;
        if (A.length ==1) return true;
        int left = 0;
        int right = A[0];
        int lastRight = 0;
        while(right<A.length - 1) {
            int maxRight = 0;
            int newLeft = left, newRight = right;
            for (int i = left; i <= right; ++i) {
                if (i + A[i] > maxRight) {
                    maxRight = i + A[i];
                    newLeft = i;
                    newRight = maxRight;
                }
            }
            left = newLeft;
            right = newRight;
            if(lastRight==right) {
                return false;
            }
            lastRight = right;
        }
        return true;
    }
}
