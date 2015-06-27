package me.billhsu;

/**
 * Created by Shipeng Xu on 27/6/15.
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class Solution_validateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean dfs(TreeNode root, long max, long min) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return dfs(root.left, root.val, min) && dfs(root.right, max, root.val);
    }
}