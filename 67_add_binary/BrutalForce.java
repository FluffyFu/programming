/*
 * Problem name: Add Binary
 * Solve date: Wed Sep 25 21:09:46 2019
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Notes: Copy the solution from "Short AC solution in Java with explanation" Things learned here:
 *  StringBuilder can help you do string manipulate more easily. Especially append and reverse method.
 *  Also StringBuilder can append different types, and convert them to string implicitly before appending.
 *
 *  Char are represented by int and you can do arithmetics with them.
 *
 *  This solution use -- in a clean way.
 */

import java.lang.StringBuilder;

public class BrutalForce {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while(i >=0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "111";
        String b = "1";
        String res = new BrutalForce().addBinary(a, b);
        System.out.println(res);
        assert 'A' == 65;
    }
}
