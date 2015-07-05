package me.billhsu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shipeng Xu on 5/7/15.
 * https://leetcode.com/problems/restore-ip-addresses/
 */
public class Solution_restoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        solve(result, "", s, 0, 3);
        return result;
    }

    private void solve(List<String> result, String current, String s, int pos, int dots) {
        if (dots == 0) {
            if (isValid(s.substring(pos))) result.add(current + s.substring(pos));
            return;
        }

        for (int i = 0; i < 3; ++i) {
            if (pos + i < s.length() - dots) {
                String currentSeg = s.substring(pos, pos + i + 1);
                if (isValid(currentSeg)) {
                    solve(result, current + currentSeg + ".", s, pos + i + 1, dots - 1);
                }
            }
        }
    }

    private boolean isValid(String s) {
        if (s.length() > 3) return false;
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        if (s.length() > 2 && s.charAt(0) == '0' && s.charAt(1) == '0') return false;
        return Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 255;
    }
}
