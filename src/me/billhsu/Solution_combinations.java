package me.billhsu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shipeng Xu on 11/6/15.
 */
public class Solution_combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, new ArrayList<Integer>(), n, k);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> currentList, int n, int k) {
        if (currentList.size() == k) {
            result.add(new ArrayList<Integer>(currentList));
            return;
        }
        int startIndex = 0;
        if (currentList.size()>0) startIndex = currentList.get(currentList.size() - 1);
        for (int i=startIndex; i<n; ++i) {
            currentList.add(i+1);
            dfs(result, currentList, n, k);
            currentList.remove(currentList.size() - 1);
        }
    }
}
