package me.billhsu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shipeng Xu on 21/8/15.
 * https://leetcode.com/problems/path-sum-ii/
 */
public class Solution_pathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        dfs(root, sum, new ArrayList<Integer>(), result);
        return result;
    }

    private void dfs(TreeNode root, int sum, List<Integer> current, List<List<Integer>> result) {
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> newCurrent = new ArrayList<Integer>(current);
            newCurrent.add(root.val);
            result.add(newCurrent);
            return;
        }
        if (root.left != null) {
            current.add(root.val);
            dfs(root.left, sum - root.val, current, result);
            current.remove(current.size() - 1);
        }
        if (root.right != null) {
            current.add(root.val);
            dfs(root.right, sum - root.val, current, result);
            current.remove(current.size() - 1);
        }
    }
}
