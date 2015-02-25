package me.billhsu;

/**
 * Created by Shipeng Xu on 2/25/15.
 * https://oj.leetcode.com/problems/multiply-strings/
 */
public class Solution_multiplyStrings {
    public String multiply(String num1, String num2) {
        String result = "";
        String new1 = num1;
        String new2 = num2;
        if(num1.length()<num2.length()) {
            String tmp = new1;
            new1 = new2;
            new2 = tmp;
        }
        for(int i=new2.length()-1; i>=0; --i) {
            String tmpResult = multiply(new1, new2.charAt(i), new2.length()-1 - i);
            result = add(tmpResult, result);
        }
        int resultStart = 0;
        for(int i=0; i<result.length()-1; ++i) {
            if(result.charAt(i) == '0') resultStart = i+1;
            else break;
        }
        return result.substring(resultStart);
    }
    private String add(String a, String b) {
        String result = "";
        String newA = new String(a);
        String newB = new String(b);
        if(a.length()<b.length()) {
            String tmp = newA;
            newA = newB;
            newB = tmp;
        }
        if(b.length()==0) return a;
        int lenA = newA.length();
        int lenB = newB.length();
        for(int i=0; i<lenA-lenB; ++i) {
            newB = "0" + newB;
        }
        int carry = 0;
        for(int i=newB.length() - 1; i>=0; --i) {
            int ia = newA.charAt(newA.length() - 1 - (newB.length() - 1 - i)) - '0';
            int ib = newB.charAt(i) - '0';
            int addAB = ia+ib + carry;
            int current = addAB - addAB/10*10;
            carry = addAB/10;
            result = current+result;
        }
        if(carry>0) {
            int current = carry - carry/10*10;
            result = current + result;
            carry = carry/10;
            if(carry>0) result = carry + result;
        }
        return result;
    }
    private String multiply(String s, char a, int shift) {
        int carry = 0;
        String result="";
        for(int i=s.length() - 1; i>=0; --i) {
            char b = s.charAt(i);
            int[] mul = multiply(a, b);
            int current = mul[0] + carry;
            carry = mul[1];
            int newCurrent = current - current/10*10;
            int newCarry = carry + current/10;
            current = newCurrent;
            carry = newCarry;
            result = current + result;
        }
        if(carry>0) {
            int newCurrent = carry - carry/10*10;
            int newCarry = carry/10;
            result = newCurrent + result;
            if(newCarry>0) result = newCarry + result;
        }

        for(int i=0; i<shift; ++i) {
            result = result + "0";
        }
        return result;
    }
    private int[] multiply(char a, char b) {
        int ia = a - '0';
        int ib = b - '0';
        int result = ia * ib;
        int[] resultArray = new int[2];
        resultArray[0] = result - result/10*10;
        resultArray[1] = result/10;
        return resultArray;
    }
}
