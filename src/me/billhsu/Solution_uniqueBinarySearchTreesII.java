package me.billhsu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shipeng Xu on 28/6/15.
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class Solution_uniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        if (start > end) {
            treeNodes.add(null);
            return treeNodes;
        }

        for (int i = start; i <= end; ++i) {
            List<TreeNode> leftNodes = generateTrees(start, i - 1);
            List<TreeNode> rightNodes = generateTrees(i + 1, end);
            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left;
                    treeNode.right = right;
                    treeNodes.add(treeNode);
                }
            }
        }
        return treeNodes;
    }
}
