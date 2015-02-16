package me.billhsu;

public class Main {

    public static void main(String[] args) {
	    Solution_3SumClosest solution = new Solution_3SumClosest();
        int[] input = {4,0,5,-5,3,3,0,-4,-5};
        int target = -2;
        System.out.println(solution.threeSumClosest(input, target));
    }
}
