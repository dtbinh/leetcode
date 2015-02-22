package me.billhsu;

import java.util.Stack;

/**
 * Created by Shipeng Xu on 2/21/15.
 * https://oj.leetcode.com/problems/longest-valid-parentheses/
 */
public class Solution_longestValidParentheses {
    public int longestValidParentheses(String s) {
        int max_length = 0;
        if(s.length()<=1) return 0;
        int []DP = new int[s.length()+1];
        DP[0] = 0;
        for(int i=1; i<DP.length; ++i) {
            if(s.charAt(i-1) == '(') DP[i] = 0;
            else if(s.charAt(i-1) == ')') {
                int j = i - DP[i-1] - 2;
                if(j<0 || s.charAt(j)!='(') DP[i] = 0;
                else {
                    DP[i] = DP[i-1] + 2 + DP[j];
                    if(DP[i]>max_length) max_length = DP[i];
                }
            }
        }
        return max_length;
    }
}