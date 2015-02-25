package me.billhsu;

import java.util.Arrays;

/**
 * Created by Shipeng Xu on 2/25/15.
 * https://oj.leetcode.com/problems/first-missing-positive/
 */
public class Solution_firstMissingPositive {
    public int firstMissingPositive(int[] A) {
        if(A.length == 0) return 1;
        if(A.length == 1) {
            if(A[0]==1) return 2;
            else return 1;
        }
        Arrays.sort(A);
        boolean posStarted = false;
        int lastVaildNum = 0;
        for(int i=0; i<A.length - 1; ++i) {
            if(A[i]>0 && !posStarted) {
                if(A[i]!=1) return 1;
                posStarted = true;
            }
            if(A[i]==A[i+1]) continue;
            if(A[i]>0 && A[i+1] - A[i]!=1) return A[i] + 1;
            lastVaildNum = A[i];
        }
        if(A[A.length - 1]>0) {
            if(lastVaildNum>0) {
                if(A[A.length - 1] - lastVaildNum == 1) return A[A.length - 1]+1;
                else return lastVaildNum + 1;
            } else {
                if(A[A.length - 1] == 1) return 2;
                else return 1;
            }
        }
        else return 1;
    }
}