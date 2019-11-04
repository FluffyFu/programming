/*
 * Problem name: Roman to Integer
 * Solve date: Thu Oct 31 22:14:49 2019
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * Notes: Use two adjacent pointers to scan the String. If the 2nd is larger than the 1st, the 1st
 *  value should be subtracted. Otherwise, it is added.
 */
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] input = s.toCharArray();

        int result = 0;
        int i = 0;
        int j = 1;
        for (; j < input.length; i++, j++) {
            if (map.get(input[i]) < map.get(input[j])) {
                result -= map.get(input[i]);
            }
            else result += map.get(input[i]);
        }
        result += map.get(input[i]);
    return result;
    }

    public static void main(String[] args) {
        String test = "MCMXCIV";
        Solution obj = new Solution();
        System.out.println(obj.romanToInt(test));
    }
}
 

