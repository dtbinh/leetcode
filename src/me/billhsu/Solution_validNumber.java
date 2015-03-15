package me.billhsu;

/**
 * Created by Shipeng Xu on 15/3/15.
 * https://leetcode.com/problems/valid-number/
 */
public class Solution_validNumber {
    enum InputType {
        INVALID,        // 0 Include: Alphas, '(', '&' ans so on
        SPACE,      // 1
        SIGN,       // 2 '+','-'
        DIGIT,      // 3 numbers
        DOT,            // 4 '.'
        EXPONENT,       // 5 'e' 'E'
    };
    int [][]transTable = {
            {-1,  0,  3,  1,  2, -1},//0初始无输入或者只有space的状态
            {-1,  8, -1,  1,  4,  5},//1输入了数字之后的状态
            {-1, -1, -1,  4, -1, -1},//2前面无数字，只输入了Dot的状态
            {-1, -1, -1,  1,  2, -1},//3输入了符号状态
            {-1,  8, -1,  4, -1,  5},//4前面有数字和有dot的状态
            {-1, -1,  6,  7, -1, -1},//5'e' or 'E'输入后的状态
            {-1, -1, -1,  7, -1, -1},//6输入e之后输入Sign的状态
            {-1,  8, -1,  7, -1, -1},//7输入e后输入数字的状态
            {-1,  8, -1, -1, -1, -1},//8前面有有效数输入之后，输入space的状态
    };
    public boolean isNumber(String s) {
        int state = 0;
        for (char c: s.toCharArray()) {
            InputType input = InputType.INVALID;
            if(c == ' ') input = InputType.SPACE;
            else if (c == '-' || c == '+') input = InputType.SIGN;
            else if (c >= '0' && c <= '9') input = InputType.DIGIT;
            else if (c == '.') input = InputType.DOT;
            else if (c == 'E' || c == 'e') input = InputType.EXPONENT;
            state = transTable[state][input.ordinal()];
            if(state == -1) return false;
        }
        return state == 1 || state == 4 || state == 7 || state == 8;
    }
}
