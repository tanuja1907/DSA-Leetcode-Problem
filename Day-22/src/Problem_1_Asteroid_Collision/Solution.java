package Problem_1_Asteroid_Collision;

import java.util.Arrays;
import java.util.Stack;

/**
 * T.C.-O(n)
 * S.C.-O(n)
 */
class Solution {
    /**
     * @param asteroids integers representing asteroids in a row,The indices of the asteroids in the array represent their relative position in space.
     * @return   the asteroids after collision
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean destroyed = false;
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int top = stack.peek();
                if (Math.abs(asteroid) > top) {
                    stack.pop();
                    continue;
                } else if (Math.abs(asteroid) == top) {
                    stack.pop();
                }
                destroyed = true;
                break;
            }
            if (!destroyed) {
                stack.push(asteroid);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, -5};
        Solution solution = new Solution();
        int[] result = solution.asteroidCollision(arr);
        Arrays.stream(result).forEach(x -> System.out.print(x + " "));
    }
}