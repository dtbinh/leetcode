package me.billhsu;

/**
 * Created by Shipeng Xu on 13/6/15.
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class Solution_invertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
    }
}