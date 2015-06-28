package me.billhsu;

/**
 * Created by Shipeng Xu on 28/6/15.
 * https://leetcode.com/problems/same-tree/
 */
public class Solution_sameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((q!=null && p==null) || (q==null && p!=null)) return false;
        if(q==null && p==null) return true;
        if(p.val != q.val) return false;
        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}