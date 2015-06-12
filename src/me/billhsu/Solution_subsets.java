package me.billhsu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shipeng Xu on 11/6/15.
 * https://leetcode.com/problems/subsets/
 */
public class Solution_subsets {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for(int i=1; i<= nums.length; ++i) {
            dfs(result, new ArrayList<Integer>(), i, 0, nums);
        }
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> currentList, int n, int start, int[] nums) {
        if (currentList.size() == n) {
            result.add(new ArrayList<Integer>(currentList));
            return;
        }
        for (int i = start; i < nums.length; ++i) {
            currentList.add(nums[i]);
            dfs(result, currentList, n, i + 1, nums);
            currentList.remove(currentList.size() - 1);
        }

    }
}
