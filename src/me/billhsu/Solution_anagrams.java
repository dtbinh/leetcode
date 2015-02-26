package me.billhsu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shipeng Xu on 2/26/15.
 * https://oj.leetcode.com/problems/anagrams/
 */
public class Solution_anagrams {
    public List<String> anagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<String, List<String>>();
        List<String> result = new ArrayList<String>();
        for(String s: strs) {
            String normalizedStr = normalize(s);
            if(strMap.get(normalizedStr)==null) {
                List<String> list = new ArrayList<String>();
                list.add(s);
                strMap.put(normalizedStr, list);
            } else {
                List<String> list = strMap.get(normalizedStr);
                list.add(s);
            }
        }
        for(List<String> list: strMap.values()) {
            if(list.size()>1) {
                result.addAll(list);
            }
        }
        return result;
    }
    private String normalize(String s) {
        String result = "";
        int[] table = new int[26];
        for(char c: s.toCharArray()) {
            table[c-'a']++;
        }
        for(int i=0; i<26; ++i) {
            result=result+(char)('a'+i)+table[i];
        }
        return result;
    }
}
