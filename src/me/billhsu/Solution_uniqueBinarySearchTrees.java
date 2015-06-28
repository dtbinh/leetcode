package me.billhsu;

/**
 * Created by Shipeng Xu on 28/6/15.
 * https://leetcode.com/problems/unique-binary-search-trees/
 */
public class Solution_uniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] results = new int[n+1];
        results[0] = 1;
        results[1] = 1;
        for(int i=2; i<=n; ++i) {
            for(int j=0; j<i; ++j) {
                results[i] += results[j]*results[i-j-1];
            }
        }
        return results[n];
    }
}
