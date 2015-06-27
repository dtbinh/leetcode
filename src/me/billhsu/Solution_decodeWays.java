package me.billhsu;

/**
 * Created by Shipeng Xu on 27/6/15.
 * https://leetcode.com/problems/decode-ways/
 */
public class Solution_decodeWays {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        int[] DP = new int[s.length() + 1];
        DP[0] = 1;
        if (isValid(s.substring(0, 1))) DP[1] = 1;
        else DP[1] = 0;
        for (int i = 2; i <= s.length(); i++) {
            if (isValid(s.substring(i - 1, i)))
                DP[i] = DP[i - 1];
            if (isValid(s.substring(i - 2, i)))
                DP[i] += DP[i - 2];
        }
        return DP[s.length()];
    }

    public boolean isValid(String s) {
        if (s.charAt(0) == '0') return false;
        int code = Integer.parseInt(s);
        return code >= 1 && code <= 26;
    }
}

