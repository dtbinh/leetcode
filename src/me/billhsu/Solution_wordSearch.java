package me.billhsu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Shipeng Xu on 13/6/15.
 * https://leetcode.com/problems/word-search/
 */
public class Solution_wordSearch {
    public boolean exist(char[][] board, String word) {
        processBoard(board);

        char beginChar = word.charAt(0);
        if (dfs(new ArrayList<Location>(), 0, word)) {
            return true;
        } else {
            return false;
        }
    }

    private class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            return (this.x == ((Location) obj).x && this.y == ((Location) obj).y);
        }
    }

    private HashMap<Character, List<Location>> charMap;

    private void processBoard(char[][] board) {
        charMap = new HashMap<Character, List<Location>>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                char current = board[i][j];
                if (charMap.containsKey(current)) {
                    charMap.get(current).add(new Location(i, j));
                } else {
                    List<Location> newList = new ArrayList<Location>();
                    newList.add(new Location(i, j));
                    charMap.put(current, newList);
                }
            }
        }
    }

    private List<Location> findLocationByChar(char character) {
        return charMap.get(character);
    }

    private boolean dfs(List<Location> locationHistory, int pos, String word) {
        if (pos == word.length()) {
            return true;
        }
        List<Location> posibleLocations = findLocationByChar(word.charAt(pos));
        if(posibleLocations == null) return false;
        for (Location location : posibleLocations) {
            if (locationHistory.size() > 0) {
                if (!checkAdjacent(location, locationHistory.get(locationHistory.size() - 1))) {
                    continue;
                }
                if(locationHistory.contains(location)) continue;
            }
            locationHistory.add(location);
            if (dfs(locationHistory, pos + 1, word) == true) {
                return true;
            } else {
                locationHistory.remove(locationHistory.size() - 1);
                continue;
            }
        }
        return false;
    }

    private boolean checkAdjacent(Location a, Location b) {
        if (a.equals(b)) return false;
        if (Math.abs(a.x - b.x) + Math.abs(a.y - b.y) == 1) return true;
        else return false;
    }
}
