package me.billhsu;

/**
 * Created by Shipeng Xu on 2/19/15.
 * https://oj.leetcode.com/problems/remove-element/
 */
public class Solution_removeElement {
    public int removeElement(int[] A, int elem) {
        int result = 0;
        for(int i=0; i<A.length; ++i) {
            if(A[i]!=elem) {
                A[result] = A[i];
                ++result;
            }
        }
        return result;
    }
}
