package me.billhsu;
import java.util.Arrays;
/**
 * Created by Shipeng Xu on 2/16/15.
 */
public class Solution_3Sum {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int closest_all = Integer.MAX_VALUE;
        for(int i=0; i < num.length; ++i) {
            int start = i + 1;
            int end = num.length -1;
            int closest;
            if(start >= end) break;
            int sum = num[i] + num[start] + num[end];
            closest = sum - target;
            while(true) {
                if(closest==0) {
                    return sum;
                }
                if(start >= end) break;
                sum = num[i] + num[start] + num[end];
                int currentDistance = sum - target;
                if(Math.abs(closest)>Math.abs(currentDistance)) {
                    closest = currentDistance;
                }

                if(currentDistance<0) {
                    start++;
                } else {
                    end--;
                }
            }
            if(Math.abs(closest)<Math.abs(closest_all)) {
                closest_all = closest;
            }
        }
        return closest_all + target;
    }
}
