package me.billhsu;

/**
 * Created by Shipeng Xu on 13/6/15.
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class Solution_searchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        for(int num: nums) {
            if (num == target) return true;
        }
        return false;
    }
}
