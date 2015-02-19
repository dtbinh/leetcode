package me.billhsu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shipeng Xu on 2/18/15.
 * https://oj.leetcode.com/problems/generate-parentheses/
 */
public class Solution_generateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if(n<=0) return result;
        recursiveSolver("", n, n, result);
        return result;
    }

    private void recursiveSolver(String solution,int left, int right, List<String> result) {
        System.out.println(solution + left + " " + right);
        if (left == 0 && right ==0) {
            result.add(solution);
            return;
        }
        if (left<=right && left>0) {
            recursiveSolver(solution+"(", left - 1, right, result);
            recursiveSolver(solution+")", left, right - 1, result);
        }
        else if (right>0) recursiveSolver(solution+")", left, right - 1, result);
    }
}
