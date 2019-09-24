/*
 * Problem name: last word length
 * Solve date: Mon Sep 23 22:57:01 2019
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Notes: Not very interesting. Get familiar with Java String operation.
 */

public class LastWord {
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        int lastLength = 0;

        //remove trailing spaces
        while(index >= 0 && s.charAt(index) == ' ') {
            index--;
        }

        //start counting last word length
        while(index >= 0 && s.charAt(index) != ' ') {
            lastLength++;
            index--;
        }

        return lastLength;
    }

    public static void main(String[] args) {
        String s1 = "Hello World";
        int res1 = new LastWord().lengthOfLastWord(s1);
        assert res1 == 5;

        String s2 = "World   ";
        int res2 = new LastWord().lengthOfLastWord(s2);
        assert res2 == 5;
    }
}
