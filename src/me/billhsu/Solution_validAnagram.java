package me.billhsu;

import java.util.Arrays;

/**
 * Created by Shipeng Xu on 10/8/15.
 * https://leetcode.com/problems/valid-anagram/
 */
public class Solution_validAnagram {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        String sSorted = new String(sArr);
        String tSorted = new String(tArr);
        return sSorted.equals(tSorted);
    }
}
