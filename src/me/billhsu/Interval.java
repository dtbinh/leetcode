package me.billhsu;

/**
 * Created by Shipeng Xu on 2/27/15.
 */
public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
    @Override
    public String toString() {
        return "["+start+","+end+"]";
    }
}
