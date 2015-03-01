package me.billhsu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shipeng Xu on 2/28/15.
 * https://oj.leetcode.com/problems/permutation-sequence/
 */
public class Solution_permutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> available  = new ArrayList<Integer>();
        for(int i=1; i<=n; ++i) available.add(i);
        solve(result, available, k - 1);
        String resultStr = "";
        for(Integer i:result) resultStr = resultStr + i;
        return resultStr;
    }
    private void solve(List<Integer> result, List<Integer> available, int k) {
        if(available.size()==0) return;
        int availSize = available.size();
        int numsAfterThisDigit = factorial(availSize - 1);
        result.add(available.get(k/numsAfterThisDigit));
        List<Integer> newAvailable  = new ArrayList<Integer>(available);
        newAvailable.remove(k/numsAfterThisDigit);
        solve(result, newAvailable, k - k/numsAfterThisDigit*numsAfterThisDigit);
    }
    private int factorial(int n) {
        int result = 1;
        for(int i=n; i>=1; --i) {
            result = result * i;
        }
        return result;
    }
}
