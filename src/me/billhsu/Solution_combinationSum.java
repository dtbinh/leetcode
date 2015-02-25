package me.billhsu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Shipeng Xu on 2/24/15.
 * https://oj.leetcode.com/problems/combination-sum/
 */
public class Solution_combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates.length==0) return result;
        if(candidates.length==1) {
            if(candidates[0] == target) {
                List<Integer> solution = new ArrayList<Integer>();
                solution.add(target);
                result.add(solution);
                return result;
            }
        }
        List<Integer> recurSolution = new ArrayList<Integer>();
        solve(candidates, 0, 0, target, recurSolution, result);
        return result;
    }
    private void solve(int[] candidates, int currentPos, int currentSum, int target, List<Integer> solution, List<List<Integer>> result) {
        if(currentSum==target) {
            List<Integer> solutionCpy = new ArrayList<Integer>(solution);
            Collections.sort(solutionCpy);
            result.add(solutionCpy);
            return;
        }
        if(currentSum > target) return;

        for(int i=currentPos; i<candidates.length; ++i) {
            List<Integer> newSolution = new ArrayList<Integer>(solution);
            newSolution.add(candidates[i]);
            if(isValid(newSolution, target)) {
                solve(candidates, i, currentSum + candidates[i], target, newSolution, result);
            }
            newSolution.remove(newSolution.size() - 1);
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
