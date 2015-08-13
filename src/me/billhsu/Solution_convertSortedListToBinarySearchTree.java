package me.billhsu;

/**
 * Created by Shipeng Xu on 13/8/15.
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class Solution_convertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        int[] nums = new int[size];
        current = head;
        for (int i = 0; i < size; ++i) {
            nums[i] = current.val;
            current = current.next;
        }
        return solve(nums, 0, nums.length - 1);
    }

    private TreeNode solve(int[] nums, int start, int end) {
        if (start < 0 || end >= nums.length || start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = solve(nums, start, mid - 1);
        root.right = solve(nums, mid + 1, end);
        return root;
    }
}
