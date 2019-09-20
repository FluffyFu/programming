/*
 * Problem name: Remove Element
 * Solve date: Tue Sep 17 22:20:50 2019
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * Notes: The problem requires remove the element x in place and the element order
 *  in the result array does not matter. Here we use two pointers p1, p2. p1 start
 *  from beginning and p2 starts from the end. The elements before (inclusive) p1 has
 *  been cleaned. The elements after p2 (not inclusive) are the removed elements. Every
 *  time p1 comes across x, we swap the elements in p1 and p2 and increment p1 and decrement
 *  p2. When p1 = p2, it ends.
 */

public class TwoPointer {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        else {
            int p1 = 0;
            int p2 = findNextP2(nums, val, nums.length-1);
            while (p1 <= p2) {
                if (nums[p1] == val) {
                    swap(nums, p1, p2);
                    p2 = findNextP2(nums, val, p2);
                }
                p1 += 1;
            }
        return p1;
        }
    }

    private void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

    private int findNextP2(int[] nums, int val, int p2) {
        int newp2;
        for (newp2 = p2; newp2 >= 0; newp2--) {
            if (nums[newp2] != val) {
                break;
            }
        }
        return newp2;

    }

    public static void main(String[] args) {
        int [] nums = {0, 0, 1};
        int res = new TwoPointer().removeElement(nums, 0);
        System.out.println(res);
    }
}
