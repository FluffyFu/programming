/*
 * Problem name: atoi
 * Solve date: Tue Oct 29 21:21:28 2019
 * Time Complexity: O(N) worst case: need to scan all the elements of the String.
 * Space Complexity: O(N)
 * Notes: inspired by this solution:
 *  https://leetcode.com/problems/string-to-integer-atoi/discuss/4643/Java-Solution-with-4-steps-explanations
 *  
 *  The key idea is checking overflow and if it is a valid number while going through each digits. Instead of
 *  building the integer first then doing the check.
 *
 *  edge cases:
 *      "0-1" -> 0
 *      "+0a32" -> 0
 */

import java.lang.StringBuffer;

public class Draft {
    public int myAtoi(String str) {
        int sign = 1;
        int i = 0;
        int total = 0;

        if (str.length() == 0) return 0;

        // remove leading empty space
        while (i < str.length() && str.charAt(i)==' ') i++;

        if (i == str.length()) return 0;

        // get the sign
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            if (str.charAt(i) == '-') sign = -1;
            i++;
        }

        // build the number
        while (i < str.length()) {
            int digit;
            digit = str.charAt(i) - '0';
            if (digit > 9 || digit < 0) break; // check if it is still a number.

            //check overflow
            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            i++;
        }
        return sign * total;

    }

    public static void main(String[] args) {
        String test = "-";
        Draft dt = new Draft();
        System.out.println(dt.myAtoi(test));

    }
}
