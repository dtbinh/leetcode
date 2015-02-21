package me.billhsu;

import java.util.*;

/**
 * Created by Shipeng Xu on 2/19/15.
 * https://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
public class Solution_substringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        if(L.length == 0) return result;
        if(L[0] == null) return result;
        if(S.length()<L.length*L[0].length()) return result;

        Map<String, Integer> hashL = new HashMap<String, Integer>();
        for(String l:L) {
            int count = 1;
            if(hashL.get(l)!=null) count+=hashL.get(l);
            hashL.put(l, count);
        }

        for(int i=0; i<=S.length() - L.length*L[0].length(); ++i) {
            String currentStr = S.substring(i, i + L.length*L[0].length());
            Map<String, Integer> hashLCopy = new HashMap<String, Integer>(hashL);
            for(int j=0; j<L.length; ++j) {
                String token = currentStr.substring(j*L[0].length(), (j+1)*L[0].length());
                if(hashLCopy.containsKey(token)) {
                    if(hashLCopy.get(token) - 1==0) {
                        hashLCopy.remove(token);
                    } else {
                        hashLCopy.put(token, hashLCopy.get(token) - 1);
                    }
                }
            }

            if(hashLCopy.size() == 0) {
                result.add(i);
                System.out.println(currentStr + " " +i);
            }
        }
        return result;
    }
    // the following function will get a time limit error:(
    private void recursiveSolution(List<Integer>result, List<Integer>available, int n, List<List<Integer>> solutions) {
        if(result.size() == n) {
            solutions.add(result);
            return;
        }
        for(int i=0; i<available.size(); ++i) {
            int currentInt = available.get(i);
            List<Integer> newResult = new ArrayList<Integer>(result);
            newResult.add(currentInt);
            List<Integer> newAvail = new ArrayList<Integer>(available);
            newAvail.remove(i);
            recursiveSolution(newResult, newAvail, n, solutions);
        }
    }
}
