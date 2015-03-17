package me.billhsu;

import java.util.Stack;

/**
 * Created by Shipeng Xu on 17/3/15.
 * https://leetcode.com/problems/simplify-path/
 */
public class Solution_simplifyPath {
    public String simplifyPath(String path) {
        Stack<String> filePath = new Stack<String>();
        String last = "";
        for(char c: path.toCharArray()) {
            if(c == '/' && !last.equals("")) {
                if(last.equals(".")) {

                } else if (last.equals("..")) {
                    if(filePath.size()>0) filePath.pop();
                } else {
                    filePath.push(last);
                }
                last = "";
            }
            if(c != '/') last = last + c;
        }
        if(!last.equals("")) {
            if(last.equals(".")) {

            } else if (last.equals("..")) {
                if(filePath.size()>0) filePath.pop();
            } else {
                filePath.push(last);
            }
        }
        String result = "";
        for(String s: filePath) {
            result += "/" + s;
        }
        if(result.equals("")) result = "/";
        return result;
    }
}
