/*
 * Problem name: Plus one
 * Solve date: Tue Sep 24 21:16:29 2019
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Notes: Straightforward idea. Convert the list to longeger, plus one, then convert it back
 *  to a list.
 *  Java Stack does not give FILO behavior when using for loop. Deque does give FILO behavior.
 *  Also this method does not scale to Array size larger than 30, which exceeds java long range.
 *  This implementation does not pass all the tests on leetcode.
 */
import java.util.*;

public class ListToInt {
    public int[] plusOne(int[] digits) {
        long beforeInt = listToInt(digits);
        int[] afterList = intToList(beforeInt + 1);
        return afterList;
    }

    private long listToInt(int[] digits) {
        long num = 0;
        for (int i = 0; i < digits.length; i++) {
            num = num * 10 + digits[i];
        }
        return num;
    }

    private int[] intToList(long num) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        while (num > 0) {
            stack.push((int)(num % 10));
            num /= 10;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        for (int digit : stack) {
            res[i] = digit;
            i+=1;
        }
        return res;
    }

    public static void main (String[] args) {
        int[] test = {9, 8, 0, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] res = new ListToInt().plusOne(test);
        for (int i=0; i<res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
