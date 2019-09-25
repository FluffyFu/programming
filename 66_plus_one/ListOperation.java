/*
 * Problem name: Plus One
 * Solve date: Tue Sep 24 22:33:57 2019
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * Notes: Operate the list directly. Use a boolean to indicate if there is a carry.
 */

public class ListOperation {
    public int[] plusOne(int[] digits) {
        boolean increment=true;
        int i = digits.length -1;
        int temp;
        while (i >= 0 && increment) {
             temp = digits[i] + 1;
             if (temp == 10) {
                 digits[i] = 0;
             }
             else {
                 digits[i] = temp;
                 increment=false;
             }
             i-=1;
        }
        if (increment) {
            // if we need to augment the array size the result must be 100000
            // so we can take advantage of it.
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        else {
            return digits;
        }
    }



    public static void main (String[] args) {
        int[] test = {9, 8, 0, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] res = new ListOperation().plusOne(test);
        for (int i=0; i<res.length; i++) {
            System.out.println(res[i]);
        }

        int[] test2 = {9};
        int[] res2 = new ListOperation().plusOne(test2);
        for (int i=0; i<res2.length; i++) {
            System.out.println(res2[i]);
        }
    }
}
