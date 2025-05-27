package Problem_3_Equal_row_and_columns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
 * T.C.-O(n^2)
 * S.C.-O(n^2)
 */
class Solution {

    /**
     * @param grid 0-indexed n x n integer matrix grid
     * @return number of pairs (ri, cj) such that row ri and column cj are equal.
     */
    public int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        int n = grid.length;
        for (int[] row : grid) {                     // first iterating each row  in grid
            List<Integer> rowList = new ArrayList<>();
            for (int col = 0; col < n; col++) {
                rowList.add(row[col]);              // adding each row in rowList
            }
            map.put(rowList, map.getOrDefault(rowList, 0) + 1);  // put row in map if already exist count increase
        }

        int count = 0;                             // initialize a variable
        for (int col = 0; col < n; col++) {        // iterating column in grid now
            List<Integer> colList = new ArrayList<>();
            for (int[] row : grid) {
                colList.add(row[col]);
            }
            count += map.getOrDefault(colList, 0); // checks and count if row already present as column
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
                {3, 1, 2, 2},
                {1, 4, 4, 5},
                {2, 4, 2, 2},
                {2, 4, 2, 2}
        };
        System.out.println(solution.equalPairs(grid));
    }
}
