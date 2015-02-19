package me.billhsu;

/**
 * Created by Shipeng Xu on 2/19/15.
 * https://oj.leetcode.com/problems/divide-two-integers/
 */
public class Solution_divideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        int sign = 1;
        if(dividend<0 && divisor>0 || dividend>0 && divisor<0) {
            sign = -1;
        }
        long dividendL = dividend;
        long divisorL  = divisor;
        if(dividendL<0) dividendL = -dividendL;
        if(divisorL<0) divisorL = -divisorL;
        if(divisorL>dividendL) return 0;
        if(divisorL == dividendL) return sign;

        int shift = 0;
        while(true) {
            if(shift>=30) break;
            if(dividendL > divisorL<<(shift+1)) ++shift;
            else break;
        }
        long remain = dividendL;
        long result = 0;
        while (remain>0) {
            long shiftedDivisor = divisorL<<shift;
            long times = 1<<shift;
            remain = remain - shiftedDivisor;
            if(remain>=0) {
                result += times;
            } else {
                if(shift>0) {
                    --shift;
                    remain = remain + shiftedDivisor;
                } else {
                    break;
                }
            }
        }
        if(result>=Integer.MAX_VALUE && sign ==1) return Integer.MAX_VALUE;
        if(sign== -1 && -result<=Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(sign == 1) return (int)result;
        else return -(int)result;
    }
}
