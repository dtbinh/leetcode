package me.billhsu;

/**
 * Created by Shipeng Xu on 13/8/15.
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class Solution_convertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }

    private TreeNode solve(int[] nums, int start, int end) {
        if (start < 0 || end >= nums.length || start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = solve(nums, start, mid - 1);
        root.right = solve(nums, mid + 1, end);
        return root;
    }
}
