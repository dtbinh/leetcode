package me.billhsu;

/**
 * Created by Shipeng Xu on 18/3/15.
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class Solution_searchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int lo = 0;
        int hi = n - 1;
        while(lo<=hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[mid][0]>target) hi = mid - 1;
            else if (matrix[mid][0]<target) lo = mid + 1;
            else return true;
        }
        int lineSearch = lo;
        if(lineSearch>n - 1) lineSearch = n - 1;
        else if (lineSearch<0) lineSearch = 0;
        if(matrix[lineSearch][0]>target) --lineSearch;
        if(lineSearch<0) return false;
        lo = 0;
        hi = m - 1;
        while(lo<=hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[lineSearch][mid]>target) hi = mid - 1;
            else if (matrix[lineSearch][mid]<target) lo = mid + 1;
            else return true;
        }
        return false;

    }
}
