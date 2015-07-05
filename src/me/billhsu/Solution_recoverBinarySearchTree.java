package me.billhsu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Shipeng Xu on 5/7/15.
 * https://leetcode.com/problems/recover-binary-search-tree/
 */
public class Solution_recoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        List<Integer> previousList = new ArrayList<Integer>();
        inOrderVisit(previousList, root);
        Collections.sort(previousList);
        pos = 0;
        inOrderAssign(previousList, root);
    }

    private void inOrderVisit(List<Integer> list, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrderVisit(list, treeNode.left);
        list.add(treeNode.val);
        inOrderVisit(list, treeNode.right);
    }

    private int pos = 0;

    private void inOrderAssign(List<Integer> list, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrderAssign(list, treeNode.left);
        treeNode.val = list.get(pos);
        pos++;
        inOrderAssign(list, treeNode.right);
    }
}
