/*
 * Problem name: 3 Longest substring without repeating characters.
 * Solve date: Sat Oct 26 18:10:35 2019
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Notes: solution from https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1729/11-line-simple-Java-solution-O(n)-with-explanation
 *  The idea is using a hashmap to store the characters (key) and its position (value). Use two pointer to keep the current substring
 *  candidate. When the right pointer meets a char that has already appeared, update the left pointer to
 *  max(current_left_pointer, pos_char + 1).
 */
// import java.lang.*;
import java.util.HashMap;

public class HashMapAndTwoPointer {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLen = 0;
        for (int i=0, j=0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            maxLen = Math.max(maxLen, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return maxLen;
    }

    public static void main (String[] args) {
        String s = " ";
        HashMapAndTwoPointer obj = new HashMapAndTwoPointer();
        int res = obj.lengthOfLongestSubstring(s);

        System.out.println(res);
    }
}
