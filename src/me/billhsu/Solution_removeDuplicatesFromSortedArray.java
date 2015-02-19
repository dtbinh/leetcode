package me.billhsu;

/**
 * Created by Shipeng Xu on 2/19/15.
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class Solution_removeDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        int lastInt = Integer.MIN_VALUE;
        int result = 0;
        for(int i=0; i<A.length; ++i) {
            if(lastInt!=A[i]) {
                lastInt = A[i];
                A[result] = A[i];
                ++result;
            }
        }
        return result;
    }
}
