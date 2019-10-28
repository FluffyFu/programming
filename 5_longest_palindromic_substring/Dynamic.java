/*
 * Problem name: Longest palindromic substring
 * Solve date: Sun Oct 27 15:32:16 2019
 * Time Complexity: O(N**2)
 * Space Complexity: O(N**2)
 * Notes: Dynamic programming. For a given string s, s[i, j] is a palindrome if s[i+1, j-1] is a
 *  palindrome and s[i] == s[j]. Use a 2D boolean array to store the information.
 */

public class Dynamic {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        Boolean[][] dp = new Boolean[s.length()][s.length()];
        int maxLen = 0;
        int start = 0, end = 0;

        for (int i=s.length()-1; i>=0; i--) {
            for (int j=i; j<s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j-i+1 <= 3 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (maxLen < j - i + 1) {
                        maxLen = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
                else dp[i][j] = false;
            }
        }
        return s.substring(start, end+1);
    }

    public static void main(String[] args) {
        String s = "aaaa";
        Dynamic dp = new Dynamic();
        System.out.println(dp.longestPalindrome(s));
    }
}
