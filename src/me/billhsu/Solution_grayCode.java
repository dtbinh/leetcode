package me.billhsu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shipeng Xu on 22/6/15.
 * https://leetcode.com/problems/gray-code/
 */
public class Solution_grayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if (n<0) return result;
        result.add(0);
        if(n<1) return result;
        int factor = 1;
        for (int i=1; i<=n; ++i) {
            int size = result.size();
            for (int j=size-1; j>= 0; --j) {
                result.add(factor + result.get(j));
            }
            factor = factor * 2;
        }
        return result;
    }
}
