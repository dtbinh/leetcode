package me.billhsu;

/**
 * Created by Shipeng Xu on 2/22/15.
 * https://oj.leetcode.com/problems/search-for-a-range/
 */
public class Solution_searchForARange {
    public int[] searchRange(int[] A, int target) {
        int [] result = {-1,-1};
        int pos = binarySearch(A, 0, A.length - 1, target);
        if(pos!=-1) {
            result[0] = pos;
            result[1] = pos;
            for(int i = pos - 1; i>=0; i--) {
                if(A[i] == A[pos]) result[0] = i;
                else break;
            }
            for(int i = pos + 1; i<A.length; i++) {
                if(A[i] == A[pos]) result[1] = i;
                else break;
            }
        }
        return result;
    }
    private int binarySearch(int[] A, int start, int end, int val) {
        int lo = start;
        int hi = end;
        while(lo<=hi) {
            int mid = lo + (hi - lo) / 2;
            if(A[mid]>val) hi = mid - 1;
            else if(A[mid]<val) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
