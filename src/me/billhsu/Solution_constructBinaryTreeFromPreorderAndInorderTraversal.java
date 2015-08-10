package me.billhsu;

/**
 * Created by Shipeng Xu on 10/8/15.
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Solution_constructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return builder(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode builder(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int breakPos = 0;
        for (int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == preorder[preStart]) {
                breakPos = i;
                break;
            }
        }
        root.left = builder(preorder, preStart + 1, preStart + breakPos - inStart, inorder, inStart, breakPos - 1);
        root.right = builder(preorder, preStart + breakPos - inStart + 1, preEnd, inorder, breakPos + 1, inEnd);
        return root;
    }
}
