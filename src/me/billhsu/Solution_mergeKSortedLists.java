package me.billhsu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Shipeng Xu on 2/19/15.
 * https://oj.leetcode.com/problems/merge-k-sorted-lists/
 */
public class Solution_mergeKSortedLists {
    public ListNode mergeKLists(List<ListNode> lists) {
//        The commented out code works fine but will get a Time-Limit error
//        ListNode head = null;
//        ListNode current = null;
//        int size = lists.size();
//        ListNode[] nodeHeads = new ListNode[size];
//        for(int i=0; i<size; ++i) {
//            nodeHeads[i] = lists.get(i);
//        }
//        while(true) {
//            int minValue = Integer.MAX_VALUE;
//            int minNodeIndex = 0;
//            boolean allNodesDone = true;
//            for(int i=0; i<size; ++i) {
//                if(nodeHeads[i] != null) {
//                    allNodesDone = false;
//                }
//                if(nodeHeads[i]!=null && nodeHeads[i].val<minValue) {
//                    minValue = nodeHeads[i].val;
//                    minNodeIndex = i;
//                }
//            }
//            if(allNodesDone == true) break;
//            ListNode l = new ListNode(nodeHeads[minNodeIndex].val);
//            if(current == null) {
//                current = l;
//                head = current;
//            } else {
//                current.next = l;
//                current = current.next;
//            }
//            nodeHeads[minNodeIndex] = nodeHeads[minNodeIndex].next;
//        }
//        return head;

        int size = lists.size();
        if(size<=0)  return null;
        List<Integer> vals = new ArrayList<Integer>();
        for(int i=0; i<size; ++i) {
            ListNode node = lists.get(i);
            if(node!=null) {
                vals.add(node.val);
                ListNode nextNode = node.next;
                while (nextNode != null) {
                    vals.add(nextNode.val);
                    nextNode = nextNode.next;
                }
            }
        }
        Collections.sort(vals);
        ListNode[] nodes = new ListNode[vals.size()];
        for(int i=0; i<vals.size(); ++i) {
            nodes[i] = new ListNode(-1);
        }
        for(int i=0; i<vals.size(); ++i) {
            nodes[i].val = vals.get(i);
            if(i<vals.size() - 1) nodes[i].next = nodes[i+1];
            else nodes[i].next = null;
        }
        if(nodes.length <= 0) return null;
        return nodes[0];
    }
}
