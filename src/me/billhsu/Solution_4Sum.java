package me.billhsu;

import java.util.*;

/**
 * Created by Shipeng Xu on 2/18/15.
 * https://oj.leetcode.com/problems/4sum/
 */
public class Solution_4Sum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        int size = num.length;
        Set<List<Integer>> resultSet = new HashSet<List<Integer>>();
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        class ValuePair {
            public ValuePair(int a, int b) {
                this.a = a;
                this.b = b;
            }
            public int a;
            public int b;

            @Override
            public String toString() {
                return a+" "+b;
            }
        }
        HashMap hashmap = new HashMap<Integer, List<ValuePair>>();
        for(int i=0; i<size; ++i) {
            for(int j=0; j<size; ++j) {
                if(i!=j) {
                    int key = num[i] + num[j];
                    List<ValuePair> list = (List<ValuePair>)hashmap.get(key);
                    ValuePair vp = new ValuePair(i, j);
                    if(list != null) {
                        list.add(vp);
                    } else {
                        list = new ArrayList<ValuePair>();
                        list.add(vp);
                        hashmap.put(key, list);
                    }
                }
            }
        }
        Iterator it = hashmap.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Iterator itCurrent = ((List<ValuePair>)pair.getValue()).iterator();
            while(itCurrent.hasNext()) {
                ValuePair currentVP = (ValuePair)itCurrent.next();
                Integer requiredValue = target - (Integer)(pair.getKey());
                List<ValuePair> list = (List<ValuePair>)hashmap.get(requiredValue);
                if(list!=null) {
                    Iterator itList = list.iterator();
                    while(itList.hasNext()) {
                        ValuePair vp = (ValuePair)itList.next();
                        if(currentVP.a != vp.a && currentVP.a != vp.b
                                && currentVP.b != vp.a && currentVP.b != vp.b) {
                            List<Integer> currentList = new ArrayList<Integer>();
                            currentList.add(num[currentVP.a]);
                            currentList.add(num[currentVP.b]);
                            currentList.add(num[vp.a]);
                            currentList.add(num[vp.b]);
                            Collections.sort(currentList);
                            resultSet.add(currentList);
                        }
                    }
                }
            }
        }
        resultList.addAll(resultSet);
        return resultList;
    }
}
