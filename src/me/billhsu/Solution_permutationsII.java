package me.billhsu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shipeng Xu on 2/26/15.
 * https://oj.leetcode.com/problems/permutations-ii/
 */
public class Solution_permutationsII {
    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> recurResult = new ArrayList<Integer>();
        List<Integer> recurAvail = new ArrayList<Integer>();
        for(int i=0; i<num.length; ++i) recurAvail.add(num[i]);
        recursiveSolution(recurResult, recurAvail, num.length, result);
        return result;
    }
    private void recursiveSolution(List<Integer>result, List<Integer>available, int n, List<List<Integer>> solutions) {
        if(result.size() == n) {
            solutions.add(result);
            return;
        }
        for(int i=0; i<available.size(); ++i) {
            if(i>0 && available.get(i)==available.get(i-1)) {
                continue;
            }
            int currentInt = available.get(i);
            List<Integer> newResult = new ArrayList<Integer>(result);
            newResult.add(currentInt);
            List<Integer> newAvail = new ArrayList<Integer>(available);
            newAvail.remove(i);
            recursiveSolution(newResult, newAvail, n, solutions);
        }
    }
}
