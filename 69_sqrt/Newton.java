/*
 * Problem name: sqrt
 * Solve date: Thu Oct  3 22:09:37 2019
 * Time Complexity: ??
 * Space Complexity: O(1)
 * Notes: Approximate a function by a line. The iteration rule is
 *  x_t+1 = (a/x_t + x_t) / 2. There are two things that acquires attention:
 *  1. how to choose the initial value.
 *  2. the relation is not accurate because the calculations are done with integer.
 *  3. one of the test case is 2**31 - 1, so we cannot choose x as initial value because it would
 *  cause an overflow in the first iteration.
 *  4. Do not choose initial value from the small side, it would also cause overflow. Think about the
 *  plots!
 */


public class Newton {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int res = x-1;
        while (!isSqrt(res, x)) {
            res = (x / res + res) / 2;
            System.out.println(res);
        }
        return res;
    }

    private boolean isSqrt(int res, int x) {
        if (res <= x / res && (res+1) > x /(res+1)) {
            return true;
        }
        else return false;
    }

    public static void main(String[] args) {
        Newton nw = new Newton();
       // System.out.println(nw.mySqrt(4));
       // System.out.println(nw.mySqrt(6));
       // System.out.println(nw.mySqrt(10));
       // System.out.println(nw.mySqrt(2));
       // System.out.println(nw.mySqrt(2147395599));
        System.out.println(nw.mySqrt(2147483647));

    }
}
