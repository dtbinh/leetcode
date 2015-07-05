package me.billhsu;

/**
 * Created by Shipeng Xu on 5/7/15.
 * https://leetcode.com/problems/interleaving-string/
 * <p/>
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * <p/>
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */
public class Solution_interleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] DP = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); ++i)
            for (int j = 0; j <= s2.length(); ++j)
                DP[i][j] = false;
        DP[0][0] = true;

        for (int i = 0; i <= s1.length(); ++i) {
            for (int j = 0; j <= s2.length(); ++j) {
                if(DP[i][j]) {
                    if (i != s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
                        DP[i + 1][j] = true;
                    }
                    if (j != s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
                        DP[i][j + 1] = true;
                    }
                }
            }
        }
        return DP[s1.length()][s2.length()];
    }
    // The following solution works but will hit time-limit
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if ((s1.length() == 0 && s2.equals(s3)) || (s2.length() == 0 && s1.equals(s3))) return true;
//        if ((s1.length() == 0 && !s2.equals(s3)) || (s2.length() == 0 && !s1.equals(s3))) return false;
//        if (s3.length() == 0 && (s1.length() != 0 || s2.length() != 0)) return false;
//        if (s1.length() == 0 && s2.length() == 0) {
//            return s3.length() == 0;
//        }
//        if ((s1.length() == 1 && s2.length() > 1) || (s2.length() == 1 && s1.length() > 1)) {
//            if (s3.equals(s1 + s2) || s3.equals(s2 + s1)) return true;
//        }
//        if (s1.length() == 1 && s2.length() == 1) {
//            if (s3.equals(s1 + s2) || s3.equals(s2 + s1)) return true;
//            else return false;
//        }
//        char char1 = s1.charAt(0);
//        char char2 = s2.charAt(0);
//        char char3 = s3.charAt(0);
//
//        if(char1==char3 && char2 != char3) return isInterleave(s1.substring(1), s2, s3.substring(1));
//        else if(char2==char3 && char1 != char3) return isInterleave(s1, s2.substring(1), s3.substring(1));
//        else if (char1==char3) return isInterleave(s1.substring(1), s2, s3.substring(1))||isInterleave(s1, s2.substring(1), s3.substring(1));
//        else return false;
//    }
}
