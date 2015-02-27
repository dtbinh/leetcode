package me.billhsu;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Shipeng Xu on 2/27/15.
 * https://oj.leetcode.com/problems/merge-intervals/
 */
public class Solution_mergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<=1) return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int i = 0;
        while(i<intervals.size() - 1) {
            if(intervals.get(i+1).start<=intervals.get(i).end) {
                if(intervals.get(i+1).end<=intervals.get(i).end) {
                    intervals.get(i+1).start = intervals.get(i).start;
                    intervals.get(i+1).end = intervals.get(i).end;
                    intervals.remove(i);
                } else {
                    intervals.get(i+1).start = intervals.get(i).start;
                    intervals.remove(i);
                }
            } else {
                ++i;
            }
        }

        return intervals;
    }
}
