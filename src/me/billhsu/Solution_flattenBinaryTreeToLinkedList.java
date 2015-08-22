package me.billhsu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shipeng Xu on 22/8/15.
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class Solution_flattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        valueList = new ArrayList<Integer>();
        dfs(root);
        for (int i = 1; i < valueList.size(); ++i) {
            root.right = new TreeNode(valueList.get(i));
            root.left = null;
            root = root.right;
        }
    }

    private static List<Integer> valueList;

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        valueList.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
