/*
 * Problem name: 5 longest palindromic string
 * Solve date: Sat Oct 26 21:25:23 2019
 * Time Complexity: O(N**3)
 * Space Complexity: O(1)
 * Notes: Check all the possible start and end of a substring.
 *  speed up: 1. if the distance between start and end is less the current maxlen, we don't need to check that candidate.
 *
 */

public class BrutalForce {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;

        String res;
        int maxLen = 0;
        int finalStart = 0, finalEnd = 0;

        for (int start = 0; start < s.length(); start++) {
            for (int end = s.length() -1; end > start; end--) {
                if ((end-start+1) <= maxLen) continue;
                if (checkPalindrome(s, start, end) && (end-start+1) > maxLen) {
                    maxLen = end - start + 1;
                    finalStart = start;
                    finalEnd = end;
                }
            }
        }
        return s.substring(finalStart, finalEnd+1);
    }

    private Boolean checkPalindrome(String s, int start, int end) {
        // check if the substring of s (start, end) is a palindrome.
        int i = start, j = end;
        while(i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "cbbd";
        BrutalForce bf = new BrutalForce();
        System.out.println(bf.longestPalindrome(s));
    }
}
