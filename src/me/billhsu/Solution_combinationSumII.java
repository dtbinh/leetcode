package me.billhsu;

import java.util.*;

/**
 * Created by Shipeng Xu on 2/25/15.
 * https://oj.leetcode.com/problems/combination-sum-ii/
 */
public class Solution_combinationSumII {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<List<Integer>, Boolean> resultMap = new HashMap<List<Integer>, Boolean>();
        if(num.length==0) return result;
        if(num.length==1) {
            if(num[0] == target) {
                List<Integer> solution = new ArrayList<Integer>();
                solution.add(target);
                result.add(solution);
                return result;
            }
        }
        List<Integer> recurSolution = new ArrayList<Integer>();
        solve(num, 0, 0, target, recurSolution, resultMap);
        result = new ArrayList<List<Integer>>(resultMap.keySet());
        return result;
    }
    private void solve(int[] candidates, int currentPos, int currentSum, int target, List<Integer> solution, Map<List<Integer>, Boolean> result) {
        if(currentSum==target && result.get(solution)==null) {
            List<Integer> solutionCpy = new ArrayList<Integer>(solution);
            Collections.sort(solutionCpy);
            result.put(solutionCpy, true);
            return;
        }
        if(currentPos>=candidates.length) return;
        if(currentSum > target) return;

        for(int i=currentPos; i<candidates.length; ++i) {
            solution.add(candidates[i]);
            if(isValid(solution, target)) {
                solve(candidates, i+1, currentSum + candidates[i], target, solution, result);
            }
            solution.remove(solution.size() - 1);
        }
    }
    private boolean isValid(List<Integer> solution, int target) {
        int sum = 0;
        for(Integer i:solution) {
            sum += i;
            if(sum>target) return false;
        }
        return true;
    }
}