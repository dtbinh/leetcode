package me.billhsu;

/**
 * Created by Shipeng Xu on 2/26/15.
 * https://oj.leetcode.com/problems/powx-n/
 */
public class Solution_powxN {
    public double pow(double x, int n) {
        double result = 1;
        double lastResult = 1;
        boolean flagX = false;
        if(x<0) {
            x = -x;
            flagX = (n%2!=0);
        }
        boolean flagN = false;
        if(n<0) {
            flagN = true;
            n = -n;
        }
        while(n>0) {
            --n;
            result = result * x;
            if(!flagN){
                if(lastResult - result ==0) break;
                lastResult = result;
            } else {
                if(lastResult - 1/result ==0) break;
                lastResult = 1/result;
            }
        }
        if(flagN) result = 1/result;
        if(flagX) result = -result;
        return result;
    }
}