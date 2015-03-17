package me.billhsu;

/**
 * Created by Shipeng Xu on 15/3/15.
 * https://leetcode.com/problems/sqrtx/
 */
public class Solution_sqrtX {
    public int sqrt(int x) {
        if (x == 0) return 0;
        double last = 0;
        double current = 1;
        while (current != last)
        {
            last = current;
            current = (current + x / current) / 2;
        }
        return (int)(current);
    }
}
