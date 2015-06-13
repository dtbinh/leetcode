package me.billhsu;

/**
 * Created by Shipeng Xu on 13/6/15.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class Solution_removeDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int[] newNums = new int[nums.length];
        int length = 0;
        int lastNum = Integer.MIN_VALUE;
        int lastCnt = 0;
        for (int num: nums) {
            if(num != lastNum) {
                newNums[length] = num;
                length = length + 1;
                lastNum = num;
                lastCnt = 1;
            } else {
                lastCnt = lastCnt + 1;
                if(lastCnt<=2) {
                    newNums[length] = num;
                    length = length + 1;
                }
            }
        }
        System.arraycopy(newNums, 0, nums, 0, nums.length);
        return length;
    }
}
