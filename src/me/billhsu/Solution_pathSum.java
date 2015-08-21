package me.billhsu;

/**
 * Created by Shipeng Xu on 21/8/15.
 * https://leetcode.com/problems/path-sum/
 */
public class Solution_pathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return dfs(root, sum);
    }

    private boolean dfs(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;
        return dfs(root.left, sum - root.val) || dfs(root.right, sum - root.val);
    }
}
