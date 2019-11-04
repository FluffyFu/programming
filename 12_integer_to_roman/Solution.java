/*
 * Problem name: Integer to Roman
 * Solve date: Thu Oct 31 21:31:36 2019
 * Time Complexity: O(N)?
 * Space Complexity: O(N)?
 * Notes: Inspired by https://blog.csdn.net/lihuixuaaa/article/details/77920686
 *  The idea is that the range for one digit there are four unique numbers: 1, 4, 5, and 9. We keep subtracting
 *  the largest available number from the input to build the Roman.
 */
import java.lang.StringBuffer;

public class Solution {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] r = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuffer sb = new StringBuffer();

        int i = 0;

        while (num > 0) {
            while (num >= nums[i]) {
                num -= nums[i];
                sb.append(r[i]);
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.intToRoman(1994));
    }
}
