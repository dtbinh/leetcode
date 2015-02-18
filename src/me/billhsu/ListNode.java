package me.billhsu;

/**
 * Created by Shipeng Xu on 2/18/15.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    @Override
    public String toString() {
        String result = val + "->";
        ListNode nextNode = next;
        while(next!=null) {
            result = result + next.val + "->";
            next = next.next;
        }
        return result;
    }
}
