/**
 * Problem number: 9
 * Name: Palindrome number
 * Solve Date: 2019/09/09
 * Notes: retrieve digits from left to right and rebuild the number. Finally compare the reconstructed number with the original one.
 * time complexity: O(n)
 * space complexity: O(1)
 */

class Solution {
    public boolean isPalindrome(int x) {
        if ( x==0 ) {
            return true;
        }
        else if (x < 0) {
            return false;
        }
        else {
            int reconstruct = 0;
            int x_copy = x;
            while( x > 0 ) {
                reconstruct = reconstruct * 10 + (x % 10);
                x /= 10;
            }
            if (reconstruct == x_copy) {
                return true;
            }
            else {
                return false;
            }
        }

        public static void main(String args[]) {
            assert true == isPalindrome(121);
        }
}
