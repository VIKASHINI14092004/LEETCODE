/*
PROBLEM STATEMENT
ASTEROID COLLISON
We are given an array asteroids of integers representing asteroids in a row. 
The indices of the asteriod in the array represent their relative position in space.
For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). 
Each asteroid moves at the same speed.
Find out the state of the asteroids after all collisions. 
If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. 
Two asteroids moving in the same direction will never meet.

Example 1:
Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2:
Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.

Example 3:
Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 
Constraints:
2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0

SOLUTION */

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> ast = new Stack<>();
        int n = asteroids.length; 
        for (int i = 0; i < n; i++) {
            int current = asteroids[i];
            // Check collision only if current is moving left (<0) and top of stack moving right (>0)
            while (!ast.isEmpty() && current < 0 && ast.peek() > 0) {
                if (Math.abs(ast.peek()) < Math.abs(current)) {
                    // Top asteroid is smaller, it explodes
                    ast.pop();
                    continue; // Check again with new top
                } else if (Math.abs(ast.peek()) == Math.abs(current)) {
                    // Both are equal, both explode
                    ast.pop();
                }
                // Current asteroid is destroyed
                current = 0;
                break;
            }
            // If current asteroid survived, push it
            if (current != 0) {
                ast.push(current);
            }
        }
        int[] result = new int[ast.size()];
        int j = 0;
        for (int num : ast) {
            result[j++] = num;
        }
        return result;
    }
}
