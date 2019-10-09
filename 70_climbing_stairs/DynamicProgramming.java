/*
 * Problem name: Climbing Stairs
 * Solve date: Mon Oct  7 21:53:28 2019
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Notes: Dynamic Programming. Let M(n) be the number of ways to climb a n-steps stairs. The following equation holds:
 *  M(n) = M(n-1) + M(n-2). Use a HashMap to cache the results, otherwise, the computation grows exponentially.
 */
import java.util.HashMap;

public class DynamicProgramming {
    private HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

    public DynamicProgramming() {
        hm.put(1, 1);
        hm.put(2, 2);
    }

    public int climbStairs(int n) {
        if (hm.containsKey(n)) return hm.get(n);
        else {
            int res = climbStairs(n-1) + climbStairs(n-2);
            hm.put(n, res);
            return res;
        }
    }

    public static void main(String[] args) {
        DynamicProgramming dp = new DynamicProgramming();
        System.out.println(dp.climbStairs(3));
        System.out.println(dp.climbStairs(4));
        System.out.println(dp.climbStairs(5));
        System.out.println(dp.climbStairs(6));
    }
}
