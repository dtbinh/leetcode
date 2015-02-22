package me.billhsu;

/**
 * Created by Shipeng Xu on 2/22/15.
 * https://oj.leetcode.com/problems/search-insert-position/
 */
public class Solution_searchInsertPosition {
    public int searchInsert(int[] A, int target) {
        if(A.length==0) return 0;
        if(A.length==1) return (A[0]>=target)?0:1;
        if(target<=A[0]) return 0;
        if(target==A[A.length - 1]) return A.length - 1;
        if(target>A[A.length - 1]) return A.length;
        int lo = 0;
        int hi = A.length - 1;
        int mid = 0;
        while(lo<=hi) {
            mid = lo + (hi - lo) / 2;
            if(A[mid]>target) hi = mid - 1;
            else if(A[mid]<target) lo = mid + 1;
            else return mid;
        }
        if(A[mid]<target) mid++;
        return mid;
    }
}