package me.billhsu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Shipeng Xu on 5/7/15.
 * https://leetcode.com/problems/symmetric-tree/
 */
public class Solution_symmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<TreeNode>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            List<Integer> result = new ArrayList<Integer>();
            Queue<TreeNode> newTreeNodeQueue = new ArrayDeque<TreeNode>();
            for (TreeNode treeNode : treeNodeQueue) {
                if (treeNode != null) {
                    result.add(treeNode.val);
                    if (treeNode.left != null) newTreeNodeQueue.add(treeNode.left);
                    else if (treeNode.val != Integer.MIN_VALUE) {
                        newTreeNodeQueue.add(new TreeNode(Integer.MIN_VALUE));
                    }
                    if (treeNode.right != null) newTreeNodeQueue.add(treeNode.right);
                    else if (treeNode.val != Integer.MIN_VALUE) {
                        newTreeNodeQueue.add(new TreeNode(Integer.MIN_VALUE));
                    }
                }
            }
            treeNodeQueue.clear();
            treeNodeQueue = newTreeNodeQueue;
            int half = result.size() / 2;
            int size = result.size();
            for (int i = 0; i < half; ++i) {
                if (!result.get(i).equals(result.get(size - i - 1))) {
                    return false;
                }
            }
        }
        return true;
    }
}
