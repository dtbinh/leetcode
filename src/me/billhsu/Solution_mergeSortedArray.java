package me.billhsu;

/**
 * Created by Shipeng Xu on 14/6/15.
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class Solution_mergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m+n];
        int index1 = 0;
        int index2 = 0;
        int resultIndex = 0;
        while(index1<m && index2<n) {
            int num1 = nums1[index1];
            int num2 = nums2[index2];
            if (num1<num2) {
                result[resultIndex] = num1;
                index1 = index1 + 1;
            } else {
                result[resultIndex] = num2;
                index2 = index2 + 1;
            }
            resultIndex = resultIndex + 1;
        }
        while(index1<m) {
            int num1 = nums1[index1];
            result[resultIndex] = num1;
            index1 = index1 + 1;
            resultIndex = resultIndex + 1;
        }
        while(index2<n) {
            int num2 = nums2[index2];
            result[resultIndex] = num2;
            index2 = index2 + 1;
            resultIndex = resultIndex + 1;
        }
        System.arraycopy(result, 0, nums1, 0, m+n);
    }
}
