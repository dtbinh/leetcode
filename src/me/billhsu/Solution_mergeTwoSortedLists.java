package me.billhsu;

/**
 * Created by Shipeng Xu on 2/18/15.
 * https://oj.leetcode.com/problems/merge-two-sorted-lists/
 */
public class Solution_mergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode headl1, headl2, currentNode, head = null;
        headl1 = l1;
        headl2 = l2;
        currentNode = null;
        while(true) {
            if(headl1 == null) {
                if(headl2 != null) {
                    if(currentNode!=null) {
                        currentNode.next = headl2;
                        break;
                    } else {
                        head = headl2;
                        break;
                    }
                } else {
                    break;
                }
            } else if(headl2 == null){
                if(headl1 != null) {
                    if(currentNode!=null) {
                        currentNode.next = headl1;
                        break;
                    } else {
                        head = headl1;
                        break;
                    }
                } else {
                    break;
                }
            }
            ListNode node;
            if(headl1.val>=headl2.val) {
                node = new ListNode(headl2.val);
                headl2 = headl2.next;
            } else {
                node = new ListNode(headl1.val);
                headl1 = headl1.next;
            }
            if(currentNode == null) {
                currentNode = node;
                head = node;
            }
            else {
                currentNode.next = node;
                currentNode = currentNode.next;
            }
        }
        return head;
    }
}
