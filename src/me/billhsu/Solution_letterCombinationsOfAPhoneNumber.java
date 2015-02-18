package me.billhsu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shipeng Xu on 2/17/15.
 * https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class Solution_letterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits.equals("")) {
            result.add("");
            return result;
        }
        String[] table = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int[] trackDigits = new int[digits.length()];
        int[] trackDigitsInc = new int[digits.length()];
        int allComb = 1;
        for(int i=0; i<digits.length(); ++i) {
            trackDigits[i] = 0;
            allComb = allComb * table[digits.charAt(i) - '2'].length();
        }
        for(int c=0; c<allComb; ++c) {
            for (int i = 1; i < trackDigits.length; ++i) {
                trackDigits[i] = trackDigits[i] + trackDigitsInc[i - 1];
                trackDigitsInc[i - 1] = 0;
                if(trackDigits[i] == table[digits.charAt(i) - '2'].length()) {
                    trackDigitsInc[i] = 1;
                    trackDigits[i] = 0;
                }
            }
            result.add(digitsToString(trackDigits, table, digits));

            if(trackDigits[0] == table[digits.charAt(0) - '2'].length() - 1) {
                trackDigitsInc[0] = 1;
                trackDigits[0] = 0;
            } else {
                trackDigits[0]++;
            }
        }
        return result;
    }
    public String digitsToString(int[] array, String[] table, String digits) {
        String result = "";
        for(int i=0; i<array.length; ++i) {
            result = result + table[digits.charAt(i) - '2'].charAt(array[i]);
        }
        return result;
    }
}
