package me.billhsu;

/**
 * Created by Shipeng Xu on 2/24/15.
 * https://oj.leetcode.com/problems/count-and-say/
 */
public class Solution_countAndSay {
    public String countAndSay(int n) {
        if(n<1) return "";
        if(n==1) return "1";
        String result = "1";
        for(int i=1; i<n; ++i) {
            String newResult = "";
            int count = 0;
            for(int j=0; j<result.length(); ++j) {
                if(j<result.length() - 1) {
                    if(result.charAt(j) == result.charAt(j+1)) {
                        count++;
                    } else {
                        count++;
                        newResult = newResult + count + result.charAt(j);
                        count = 0;
                    }
                } else {
                    count++;
                    newResult = newResult + count + result.charAt(j);
                    count = 0;
                }
            }
            result = newResult;
        }
        return result;
    }
}
