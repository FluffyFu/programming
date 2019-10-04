/*
 * Problem name: sqrt(x)
 * Solve date: Wed Sep 25 22:35:13 2019
 * Time Complexity: O(log(x))
 * Space Complexity: O(1)
 * Notes: Use binary search in the window [0, x] and find a such that a^2 <= x and (a+1)^2 >x.
 */

public class BinarySearch {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int a = 1;
        int b = x;
        while (b > a) {
            int mid = a + (b-a) / 2;
            if (compare(mid, x) == 0) {
                return mid;
            }
            else if (compare(mid, x) > 0) {
                b = mid;
            }
            else {
                a = mid;
            }
        }
        return a;
    }

    private int compare(int num, int x) {
        // check is num is larger, smaller or equal to sqrt(x)
        if (num <= x/num && (num+1 > x/(num+1))) {
            return 0;
        }
        else if (num > x/num) {
            return 1;
        }
        else return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.mySqrt(4));
        System.out.println(bs.mySqrt(6));
        System.out.println(bs.mySqrt(10));
        System.out.println(bs.mySqrt(2));
        System.out.println(bs.mySqrt(2147395599));

    }
}
