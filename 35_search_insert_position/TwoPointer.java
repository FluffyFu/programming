/*
 * Problem name: Search Insert Postion
 * Solve date: Thu Sep 19 22:34:57 2019
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * Notes: Use two pointers p1 and p2. p1 starts from the left and p2 starts from the left.
 *  At each step, p1 increments 1 and p2 decrement 1 if nums[p1] < val and nums[p2] > val.
 *  The iteration ends when p1 >= p2. There are two possibilities: if nums[p1] == val, return p1 (found).
 *  if nums[p1] < val return p1 + 1(not found).
 */

public class TwoPointer {
    public int searchInseart(int[] nums , int target) {
        if (nums.length == 0) {
            return 0;
        }
        else {
            int p1 = 0, p2 = nums.length - 1;
            while (p1 < p2) {
                if (nums[p1] < target) {
                    p1 += 1;
                }
                if (nums[p2] > target) {
                    p2 -= 1;
                }
                if (nums[p1] == target) {
                    return p1;
                }
                if (nums[p2] == target) {
                    return p2;
                }
            }

            if (p1 == p2) {
                if (nums[p1] >= target) {
                    return p1;
                }
                else {
                    return p1 + 1;
                }
            }

            else {
                return p1;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int target1 = 2;
        int res1 = new TwoPointer().searchInseart(nums1, target1);
        assert 1 == res1;

        int[] nums2 = {1, 2, 3};
        int target2 = 4;
        int res2 = new TwoPointer().searchInseart(nums2, target2);
        assert 3 == res2;

        int[] nums3 = {1, 2, 5, 5};
        int target3 = 4;
        int res3 = new TwoPointer().searchInseart(nums3, target3);
        assert 2 == res3;

        int[] nums4 = {1, 3, 5, 6};
        int target4 = 2;
        int res4 = new TwoPointer().searchInseart(nums4, target4);
        assert 1 == res4;
    }
}
