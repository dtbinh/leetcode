package me.billhsu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Shipeng Xu on 2/21/15.
 * https://oj.leetcode.com/problems/next-permutation/
 */
public class Solution_nextPermutation {
    public void nextPermutation(int[] num) {
        int pivot = -1;
        if(num.length<=1) return;
        for(int i=0; i<num.length - 1; ++i) {
            if(num[i]<num[i+1]) {
                pivot = i;
            }
        }

        if(pivot == -1) {
            ArrayList<Integer> list = new ArrayList<Integer>(num.length);
            for (int i = 0; i < num.length; i++)
                list.add(Integer.valueOf(num[i]));
            Collections.sort(list);
            for (int i = 0; i < num.length; i++) {
                num[i] = list.get(i);
            }
            return;
        }


        int swapPos = 0;
        int minDist = Integer.MAX_VALUE;
        for(int i=pivot+1; i<num.length; ++i) {
            if(num[i]>num[pivot]) {
                if(num[i] - num[pivot]<=minDist) {
                    swapPos = i;
                    minDist = num[i] - num[pivot];
                }
            }
        }

        int num_pivot = num[pivot];
        num[pivot] = num[swapPos];
        num[swapPos] = num_pivot;

        for(int i=pivot+1; i<pivot+1 + (num.length - (pivot+1))/2; ++i) {
            int tmp = num[i];
            num[i] = num[num.length - (i-(pivot+1)) - 1];
            num[num.length - (i-(pivot+1)) - 1] = tmp;
        }
    }
}
