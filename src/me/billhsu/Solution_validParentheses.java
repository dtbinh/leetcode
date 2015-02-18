package me.billhsu;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by Shipeng Xu on 2/18/15.
 * https://oj.leetcode.com/problems/valid-parentheses/
 */
public class Solution_validParentheses {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        for(int i=0; i<s.length(); ++i) {
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{') {
                stack.push(s.charAt(i));
            } else {
                Character currentChar = s.charAt(i);
                Character stackChar = null;
                try {
                    stackChar = (Character) stack.peek();
                } catch (Exception ex) {
                    return false;
                }
                if(stackChar=='(' && currentChar!=')' ||
                        stackChar=='[' && currentChar!=']' ||
                        stackChar=='{' && currentChar!='}') {
                    System.out.println(stack.peek() + " " + s.charAt(i));
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
