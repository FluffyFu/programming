/*
 * Problem name: Longest palindrome substring.
 * Solve date: Sun Oct 27 15:58:40 2019
 * Time Complexity: O(N**2)
 * Space Complexity: O(1)
 * Notes: "build" the palindrome from the center. Consider two cases: palindrome is even or odd.
 *  This method is 20 times faster than the brutal force method.
 */

public class ExtendFromCenter {
    private int maxLen, start;

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        for (int i=0; i<s.length()-1; i++) {

            maxLenPalindrome(s, i, i); // palindrome length is odd.
            maxLenPalindrome(s, i, i+1); // palindrome length is even.
        }
        return s.substring(start, maxLen+start);

    }

    private void maxLenPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        // when the loop is finished i and j are 1 position off.
        if (maxLen < j-i-1) {
            maxLen = j - i - 1;
            start = i + 1;
        }
    }

    public static void main(String[] args) {
        String s = "babad";
        ExtendFromCenter ec = new ExtendFromCenter();
        System.out.println(ec.longestPalindrome(s));
    }
}
