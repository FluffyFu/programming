/*
 * Problem name: Climb Stairs
 * Solve date: Mon Oct  7 22:19:57 2019
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * Notes: Iterative method, keep track of the current step and two previous methods counts.
 */

public class IterativeMethod {
    public int climbStairs(int n) {
        if (n==1) return 1;
        if (n==2) return 2;
        int a=1;
        int b=2;

        while(n>2) {
            int temp = b;
            b = a+b;
            a = temp;
            n--;
        }
        return b;
    }

    public static void main(String[] args) {
        IterativeMethod im = new IterativeMethod();
        System.out.println(im.climbStairs(3));
        System.out.println(im.climbStairs(4));
        System.out.println(im.climbStairs(5));
        System.out.println(im.climbStairs(6));
    }
}
