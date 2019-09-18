/*
 * Problem name: Remove Duplicates from Two Sorted Arrays
 * Solve date: Tue Sep 17 21:32:42 2019
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * Notes: This question requires to remove duplicates in place. This implementation uses two pointer.
 *  One pointer p1 is used as the bounder to separate sorted and sorted. The other p2 one keeps scanning and
 *  if it encounters a value different from that pointed by the first pointer. We do a swap between p1's next
 *  position and p2. Then increment both p1 and p2.
 */

public class TwoPointer {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        else {
            int p1 = 0, p2 = 0;
            while (p2 < nums.length) {
                if (nums[p1] != nums[p2]) {
                    swap(nums, p1+1, p2);
                    p1 += 1;
                }
                p2 += 1;
            }
            return p1 + 1;
        }
    }

    private void swap(int[] nums, int n, int m) {
        /*
         * swap the number at index n and index m
         */
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 2, 2, 3, 4};
        int res = new TwoPointer().removeDuplicates(nums);
        System.out.println(res);
    }
}
