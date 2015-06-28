package me.billhsu;

import java.util.*;

/**
 * Created by Shipeng Xu on 28/6/15.
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class Solution_binaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode current = root;
        while (!treeNodeStack.isEmpty() || current!=null) {
            if(current!=null) {
                treeNodeStack.push(current);
                current = current.left;
            } else {
                TreeNode treeNode = treeNodeStack.pop();
                result.add(treeNode.val);
                current = treeNode.right;
            }
        }
        return result;
    }

    /*
    // Recursive solution is trivial, as below

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        dfs(result, root);
        return result;
    }

    public void dfs(List<Integer> result, TreeNode root) {
        if (root == null) return;
        dfs(result, root.left);
        result.add(root.val);
        dfs(result, root.right);
    }
    */
}