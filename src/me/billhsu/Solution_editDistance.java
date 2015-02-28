package me.billhsu;

/**
 * Created by Shipeng Xu on 2/28/15.
 * https://oj.leetcode.com/problems/edit-distance/
 */
public class Solution_editDistance {
    public int minDistance(String word1, String word2) {
        String new1 = word1;
        String new2 = word2;
        if(new1.length()<new2.length()) {
            String tmp = new1;
            new1 = new2;
            new2 = tmp;
        }
        if(new2.length()==0) return new1.length();
        if(new1.equals(new2)) return 0;
        if(new2.length() == 1) return 1;
        int[][] DP = new int[new1.length() + 1][new2.length() + 1];
        for(int i=0; i<=new1.length(); ++i) {
            DP[i][0] = i;
        }
        for(int i=0; i<=new2.length(); ++i) {
            DP[0][i] = i;
        }
        for(int i=0; i<new1.length();++i) {
            for(int j=0; j<new2.length(); ++j) {
                if(new1.charAt(i) == new2.charAt(j)) {
                    DP[i+1][j+1] = DP[i][j];
                } else {
                    int edit = DP[i][j] + 1;
                    int delete = DP[i][j+1] + 1;
                    int add = DP[i+1][j] +1;
                    int min = Math.min(edit,delete);
                    min = Math.min(min, add);
                    DP[i+1][j+1] = min;
                }
            }
        }

        return DP[new1.length()][new2.length()];
    }
}
