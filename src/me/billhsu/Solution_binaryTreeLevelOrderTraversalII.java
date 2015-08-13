package me.billhsu;

import java.util.*;

/**
 * Created by Shipeng Xu on 13/8/15.
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class Solution_binaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (root == null) return results;
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<TreeNode>();
        treeNodeQueue.add(root);
        List<Integer> result0 = new ArrayList<Integer>();
        result0.add(root.val);
        while (!treeNodeQueue.isEmpty()) {
            List<Integer> result = new ArrayList<Integer>();
            Queue<TreeNode> newTreeNodeQueue = new ArrayDeque<TreeNode>();
            for (TreeNode treeNode : treeNodeQueue) {
                if (treeNode != null) {
                    result.add(treeNode.val);
                    if (treeNode.left != null) newTreeNodeQueue.add(treeNode.left);
                    if (treeNode.right != null) newTreeNodeQueue.add(treeNode.right);
                }
            }
            treeNodeQueue.clear();
            treeNodeQueue = newTreeNodeQueue;
            results.add(result);
        }
        Collections.reverse(results);
        return results;
    }
}
