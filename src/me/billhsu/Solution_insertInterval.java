package me.billhsu;

import java.util.List;

/**
 * Created by Shipeng Xu on 2/27/15.
 * https://oj.leetcode.com/problems/insert-interval/
 */
public class Solution_insertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.size()==0) {
            intervals.add(newInterval);
            return intervals;
        }
        if(newInterval.start>intervals.get(intervals.size() - 1).end) {
            intervals.add(newInterval);
            return intervals;
        } else if (newInterval.end<intervals.get(0).start) {
            intervals.add(0, newInterval);
            return intervals;
        }
        int startPos = -1;
        for(int i=0; i<intervals.size(); ++i) {
            if(intervals.get(i).start>=newInterval.start) {
                startPos = i;
                break;
            }
        }
        if(startPos==-1) startPos = intervals.size();
        intervals.add(startPos, newInterval);
        int i;
        if(startPos>0) i = startPos - 1;
        else i = 0;
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
                i++;
            }
        }

        return intervals;
    }
}
