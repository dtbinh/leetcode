package me.billhsu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Shipeng Xu on 28/6/15.
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class Solution_binaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
        return results;
    }
}
