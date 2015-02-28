package me.billhsu;

/**
 * Created by Shipeng Xu on 2/28/15.
 * https://oj.leetcode.com/problems/length-of-last-word/
 */
public class Solution_lengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0;
        int startedPos = -1;
        for(int i=s.length()-1; i>=0; --i) {
            if(s.charAt(i)==' ' && startedPos!=-1) return startedPos - i;
            if(s.charAt(i)!=' ' && startedPos==-1) startedPos = i;
        }
        if(startedPos == -1) return 0;
        else return startedPos + 1;
    }
}
