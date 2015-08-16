package me.billhsu;

/**
 * Created by Shipeng Xu on 13/8/15.
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class Solution_balancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        balanced = true;
        dfs(root);
        return balanced;
    }

    private static boolean balanced = true;

    private void dfs(TreeNode node) {
        if (node == null || !balanced) {
            return;
        }
        int depthLeft = depth(node.left);
        int depthRight = depth(node.right);
        if (Math.abs(depthLeft - depthRight) > 1) {
            balanced = false;
        }
        dfs(node.left);
        dfs(node.right);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
