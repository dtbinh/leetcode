package me.billhsu;

import java.util.Stack;

/**
 * Created by Shipeng Xu on 2/25/15.
 * https://oj.leetcode.com/problems/trapping-rain-water/
 */
public class Solution_trappingRainWater {
    public int trap(int[] A) {
        if(A.length <= 1) return 0;
        int result = 0;

        int[] leftMostHeight = new int[A.length];
        int leftHighest = 0;
        for(int i=0; i<A.length; ++i) {
            if(A[i]>leftHighest) {
                leftHighest = A[i];
            }
            leftMostHeight[i] = leftHighest;
        }
        int rightHighest = 0;
        for(int i=A.length - 1; i>=0; --i) {
            if(A[i]>rightHighest) {
                rightHighest = A[i];
            }
            result += Math.min(leftMostHeight[i], rightHighest) - A[i];
        }
        return result;
    }
    // the following solution will get a time limit error:(
//    public int trap(int[] A) {
//        if(A.length <= 1) return 0;
//
//        int maxHeight = 0;
//        int secMaxHeight = 0;
//        for(int i:A) {
//            if(i>maxHeight) maxHeight = i;
//            else if(i>secMaxHeight) secMaxHeight = i;
//        }
//        int result = 0;
//        for(int i=0; i<secMaxHeight; ++i) {
//            Stack<Integer> stack = new Stack<Integer>();
//            for(int j=0; j<A.length; ++j) {
//                if(!stack.isEmpty()) {
//                    if(A[j]>0) result += j - stack.pop() - 1;
//                } else {
//                    if(A[j]>0) stack.push(j);
//                }
//                if(A[j]>0) A[j] --;
//            }
//        }
//        return result;
//    }
}
