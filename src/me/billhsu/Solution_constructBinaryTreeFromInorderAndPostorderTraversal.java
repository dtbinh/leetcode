package me.billhsu;

/**
 * Created by Shipeng Xu on 10/8/15.
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class Solution_constructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return builder(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode builder(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int breakPos = 0;
        for (int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == postorder[postEnd]) {
                breakPos = i;
                break;
            }
        }
        root.left = builder(postorder, postStart, postStart + breakPos - (inStart + 1), inorder, inStart, breakPos - 1);
        root.right = builder(postorder, postStart + breakPos - inStart, postEnd - 1, inorder, breakPos + 1, inEnd);
        return root;
    }
}
