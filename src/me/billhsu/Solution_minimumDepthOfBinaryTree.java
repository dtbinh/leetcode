package me.billhsu;

/**
 * Created by Shipeng Xu on 16/8/15.
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class Solution_minimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
