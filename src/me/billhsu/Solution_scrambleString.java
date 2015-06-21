package me.billhsu;

import java.util.HashMap;

/**
 * Created by Shipeng Xu on 14/6/15.
 * https://leetcode.com/problems/scramble-string/
 */
public class Solution_scrambleString {

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (Character c1 : s1.toCharArray()) {
            if (map.get(c1) == null) {
                map.put(c1, 1);
            } else {
                map.put(c1, map.get(c1) + 1);
            }
        }
        for (Character c2 : s2.toCharArray()) {
            if (map.get(c2) == null) {
                return false;
            } else {
                int val = map.get(c2);
                if (val > 1) map.put(c2, val - 1);
                else map.remove(c2);
            }
        }
        if (!map.isEmpty()) return false;
        int length = s1.length();
        for (int i = 1; i < length; ++i) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i, length);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i, length);
            if (isScramble(s11, s21) && isScramble(s12, s22)) {
                return true;
            } else {
                s21 = s2.substring(length - i, length);
                s22 = s2.substring(0, length - i);
                if (isScramble(s11, s21) && isScramble(s12, s22)) {
                    return true;
                }
            }
        }
        return false;
    }
}
