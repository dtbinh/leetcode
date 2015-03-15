package me.billhsu;

/**
 * Created by Shipeng Xu on 15/3/15.
 * https://leetcode.com/problems/add-binary/
 */
public class Solution_addBinary {
    public String addBinary(String a, String b) {
        if(b.length()<a.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        int carry = 0;
        String result = "";
        for(int i = b.length() - 1; i > b.length() - 1 - a.length(); --i) {
            int aDigit = a.charAt(a.length() - 1 - (b.length() - 1 - i)) - '0';
            int bDigit = b.charAt(i) - '0';
            int currentDigit = aDigit + bDigit + carry;
            carry = 0;
            if (currentDigit > 1) {
                result = (char)(currentDigit%2 + '0') + result;
                carry = currentDigit / 2;
            } else {
                result = (char)(currentDigit%2 + '0') + result;
            }
        }
        for(int i = b.length() - 1 - a.length(); i>=0; --i) {
            int bDigit = b.charAt(i) - '0';
            int currentDigit = bDigit + carry;
            carry = 0;
            if (currentDigit > 1) {
                result = (char)(currentDigit%2 + '0') + result;
                carry = currentDigit / 2;
            } else {
                result = (char)(currentDigit%2 + '0') + result;
            }

        }
        while(carry>0) {
            result = (char)(carry%2 + '0') + result;
            carry /= 2;
        }
        return result;
    }
}
