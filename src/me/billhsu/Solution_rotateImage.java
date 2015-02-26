package me.billhsu;

/**
 * Created by Shipeng Xu on 2/26/15.
 * https://oj.leetcode.com/problems/rotate-image/
 */
public class Solution_rotateImage {
    public void rotate(int[][] matrix) {
        int size = matrix[0].length;
        int[][] newMatrix = new int[size][size];

        for(int i=0; i<size; ++i) {
            for(int j=0; j<size; ++j) {
                newMatrix[i][size - j - 1] = matrix[j][i];
            }
        }
        for (int i = 0; i < size; i++) {
            System.arraycopy(newMatrix[i], 0, matrix[i], 0, newMatrix[i].length);
        }
    }
}
