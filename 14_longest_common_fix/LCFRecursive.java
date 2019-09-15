/*
 * Problem name: LongestCommentFix
 * Solve date: Sun Sep 15 16:36:00 2019
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Notes: Divide and Conquer. LCF(strs[]) = LCFoftwoString(LCF(first half), LCF(second half)).
 */
import java.util.Arrays;

public class LCFRecursive {
    public String LCFRecursive(String[] strs) {
        int array_len = strs.length;
        if (array_len == 0) {
            return "";
        }
        else if (array_len == 1) {
            return strs[0];
        }

        return LCFTwoStrings(LCFRecursive(Arrays.copyOfRange(strs, 0, array_len/2)),
                LCFRecursive(Arrays.copyOfRange(strs, array_len/2, array_len)));
    }

    private String LCFTwoStrings(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return "";
        }
        int shortest_len = Math.min(str1.length(), str2.length());
        int index;
        for (index=0; index<shortest_len; index++) {
            if (str1.charAt(index) != str2.charAt(index)) {
                break;
            }
        }
        if (index == 0) {
            return "";
        }
        else {
            return str1.substring(0, index);
        }
    }

    public static void main (String args[]) {
        String[] test = {"leet", "lee", "leetcode"};

        String lcf = new LCFRecursive().LCFRecursive(test);
        System.out.println(lcf);
    }
}
