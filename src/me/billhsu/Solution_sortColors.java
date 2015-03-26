package me.billhsu;

/**
 * Created by Shipeng Xu on 26/3/15.
 * https://leetcode.com/problems/sort-colors/
 */
public class Solution_sortColors {
    public void sortColors(int[] A) {
        int[] count = new int[3];
        for(int i=0; i<A.length; ++i) {
            ++count[A[i]];
        }
        for(int i=0; i<count[0]; ++i) {
            A[i] = 0;
        }
        for(int i=count[0]; i<count[0] + count[1]; ++i) {
            A[i] = 1;
        }
        for(int i=count[0] + count[1]; i<count[0] + count[1] + count[2]; ++i) {
            A[i] = 2;
        }
    }
}
