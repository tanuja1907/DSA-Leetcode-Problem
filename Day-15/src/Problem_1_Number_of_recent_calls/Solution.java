package Problem_1_Number_of_recent_calls;

import java.util.LinkedList;
import java.util.Queue;

/**
 * THIS IS CLASS RECENTCOUNTER() IN WHICH  QUEUE IS INITIALIZED IN CONSTRUCTOR
 * IN THIS PROGRAMME THERE IS WINDOW SIZE AND RETURN IS HOW MANY PING HAVE MADE IN THAT PARTICULAR WINDOW SIZE
 * IN PING METHOD T ADDED AND IT CHECKS IF THE WINDOW SIZE GREATER THAN 3000S PREVIOUS PING CALLS REMOVED
 */
class RecentCounter {
    Queue<Integer> queue;//stores timestamp of ping

    public RecentCounter() {
        queue = new LinkedList<>();

    }

    public int ping(int t) {
        queue.add(t);
        while (!queue.isEmpty() && t - 3000 > queue.peek()) {
            queue.poll();
        }

        return queue.size();
    }

}

