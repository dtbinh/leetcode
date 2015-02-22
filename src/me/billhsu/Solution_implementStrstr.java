package me.billhsu;

/**
 * Created by Shipeng Xu on 2/19/15.
 * https://oj.leetcode.com/problems/implement-strstr/
 */
public class Solution_implementStrstr {
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()) return -1;
        if(needle.length()==haystack.length()) return (needle.equals(haystack))?0:-1;
        if(needle=="") return 0;
        for(int i = 0; i <= haystack.length() - needle.length(); ++i) {
            String currentStr = haystack.substring(i, i + needle.length());
            if(needle.equals(currentStr)) {
                return i;
            }
        }
        return -1;
    }
}
