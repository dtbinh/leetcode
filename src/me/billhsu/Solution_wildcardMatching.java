package me.billhsu;

/**
 * Created by Shipeng Xu on 2/25/15.
 * https://oj.leetcode.com/problems/wildcard-matching/
 */
public class Solution_wildcardMatching {
    public boolean isMatch(String s, String p) {
        int sPos = 0;
        int pPos = 0;
        int matchPos = 0;
        int startPos = -1;
        while(sPos<s.length()) {
            if (pPos<p.length() && (s.charAt(sPos) == p.charAt(pPos) || p.charAt(pPos) == '?')) {
                sPos++;
                pPos++;
            } else if (pPos<p.length() && p.charAt(pPos) == '*') {
                startPos = pPos;
                matchPos = sPos;
                pPos++;
            } else if (startPos!=-1) {
                pPos = startPos + 1;
                matchPos++;
                sPos = matchPos;
            } else {
                return false;
            }
        }
        while (pPos < p.length() && p.charAt(pPos) == '*') pPos++;
        return pPos==p.length();
    }
}
