package Problem_1_Key_and_rooms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Using DFS approach where first edge 0 is stored in stack and then mark visited[0] as true
 * if all nodes are not visited it return false else true
 * T.C.-O(N+E) where n=number of nodes and e is number of edges
 * S.C.-o(N) for visited and stack
 */
class Solution {
    /**
     * @param rooms list of rooms which has list of keys to open
     * @return if all the rooms have been visited or not
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visited[0] = true;
        while (!stack.isEmpty()) {
            int room = stack.pop();
            for (int key : rooms.get(room)) {
                if (!visited[key]) {
                    visited[key] = true;
                    stack.push(key);
                }
            }
        }
        for (boolean visit : visited) {
            if (!visit) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(List.of(1));
        rooms.add(List.of(2));
        rooms.add(List.of(3));
        rooms.add(new ArrayList<>());
        Solution solution = new Solution();
        System.out.println(solution.canVisitAllRooms(rooms));
    }
}
