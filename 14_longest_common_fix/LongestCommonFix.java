/*
 * Problem: longest common fix
 * Solve date: 2019/09/12
 * Notes: Use 'horizontal scan'. Use the fact that the longest
 *  common fix (LCF) of n strings is LCF(n-1 , nth str)
 * Time Complexity: O(N*S) (worst scenario).
 * Space Complexity: O(1)
 *
 */

class LongestCommonFix {
    public String LongestCommonFix(String[] strs) {
        if (strs.length == 0) return "";
        String lcf = strs[0];

        for (int i=1; i<strs.length; i++) {
            while (strs[i].indexOf(lcf) != 0) {
                lcf = lcf.substring(0, lcf.length()-1);
                if (lcf.length() == 0) return "";
            }
        }
        return lcf;
    }

    public static void main(String[] args) {
        String[] strs = {"leet", "lee", "leec"};
        String res = new LongestCommonFix().LongestCommonFix(strs);
        System.out.println("longest common fix: " + res);
    }
}
