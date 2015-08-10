package me.billhsu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shipeng Xu on 10/8/15.
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 */
public class Solution_differentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        if (input == null || input.equals("")) return result;
        for (int i = 0; i < input.length(); ++i) {
            char currentChar = input.charAt(i);
            if (currentChar != '+' && currentChar != '-' && currentChar != '*') {
                continue;
            }
            List<Integer> result1 = diffWaysToCompute(input.substring(0, i));
            List<Integer> result2 = diffWaysToCompute(input.substring(i + 1, input.length()));
            for (Integer m : result1) {
                for (Integer n : result2) {
                    switch (currentChar) {
                        case '+':
                            result.add(m + n);
                            break;
                        case '-':
                            result.add(m - n);
                            break;
                        case '*':
                            result.add(m * n);
                            break;
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.parseInt(input));
        }
        return result;
    }
}
