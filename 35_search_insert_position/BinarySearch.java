/*
 * Problem name: Search Insert Postion
 * Solve date: Thu Sep 19 23:12:35 2019
 * Time Complexity: O(log(N))
 * Space Complexity: O(1)
 * Notes: Use binary search. Works faster than two pointer. However, care need be taken to
 *  make sure the correct condition is used. If target is in nums, the binary search works well
 *  by using [low, mid+1] or [mid+1, high]. However, if target is not in nums, care should be taken
 *  to deal with base cases. Note that, if nums.length >= 3, and target is not in nums, it always
 *  boils down to two numbers: [low, high]. The base case high < low can only happens when the target
 *  is smaller than low. The base low == high deals with other cases.
 */

public class BinarySearch {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        return binarySearch(nums, target, 0, nums.length-1);
    }

    private int binarySearch(int[] nums, int target, int low, int high) {
        // function to search target in nums within index window [low, high]
        if (low == high) {
            if (nums[low] >= target) {
                return low;
            }
            else {
                return low + 1;
            }
        }
        else if (high < low) {
            return low;
        }


        int mid = low + (high - low) / 2;

        if (nums[mid] == target) {
            return mid;
        }
        else if (nums[mid] < target) {
            return binarySearch(nums, target, mid+1, high);
        }
        else {
            return binarySearch(nums, target, low, mid-1);
        }
    }

    public static void main (String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int target1 = 2;
        int res1 = new BinarySearch().searchInsert(nums1, target1);
        assert 1 == res1;

        int[] nums2 = {1, 2, 3};
        int target2 = 4;
        int res2 = new BinarySearch().searchInsert(nums2, target2);
        assert 3 == res2;

        int[] nums3 = {1, 2, 5, 5};
        int target3 = 4;
        int res3 = new BinarySearch().searchInsert(nums3, target3);
        assert 2 == res3;

        int[] nums4 = {1, 3, 5, 6};
        int target4 = 2;
        int res4 = new BinarySearch().searchInsert(nums4, target4);
        assert 1 == res4;
    }
}
