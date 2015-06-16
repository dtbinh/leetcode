package me.billhsu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shipeng Xu on 16/6/15.
 * https://leetcode.com/problems/subsets-ii/
 */
public class Solution_subsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
        int lastNum = Integer.MIN_VALUE;
        for (int i = start; i < nums.length; ++i) {
            if (lastNum==nums[i]) continue;
            lastNum = nums[i];
            currentList.add(nums[i]);
            dfs(result, currentList, n, i + 1, nums);
            currentList.remove(currentList.size() - 1);
        }

    }
}