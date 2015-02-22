package me.billhsu;

/**
 * Created by Shipeng Xu on 2/22/15.
 * https://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class Solution_searchInRotatedSortedArray {
    public int search(int[] A, int target) {
        if(A.length == 0) return -1;
        if(A.length == 1) return (A[0] == target)?0:-1;

        boolean isFirstHalf = false;
        if(A[0]<=target) isFirstHalf = true;
        int pivot = 0;
        for(int i=0; i<A.length - 1; ++i) {
            if(A[i]<A[i+1]) pivot = i+1;
            else break;
        }
        if(isFirstHalf) {
            return binarySearch(A, 0, pivot, target);
        } else {
            return binarySearch(A, pivot+1, A.length - 1, target);
        }
    }
    private int binarySearch(int[] A, int start, int end, int val) {
        int lo = start;
        int hi = end;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(val<A[mid]) hi = mid - 1;
            else if (val>A[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
