package me.billhsu;

/**
 * Created by Shipeng Xu on 15/3/15.
 * https://leetcode.com/problems/plus-one/
 */
public class Solution_plusOne {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        int carry = 0;
        ++digits[digits.length - 1];
        for (int i = digits.length - 1; i >= 0; --i) {
            int currentDigit = digits[i] + carry;
            carry = 0;
            if(currentDigit>9) {
                result[i+1] = currentDigit - currentDigit / 10 * 10;
                carry = currentDigit/10;
            } else {
                result[i+1] = currentDigit;
            }
        }
        if (carry>0) result[0] = carry;
        if(result[0] == 0) {
            int[] newResult = new int[digits.length];
            System.arraycopy(result, 1, newResult, 0, digits.length);
            return newResult;
        }
        return result;
    }
}
