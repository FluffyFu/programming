/*
 * Problem name: maximum subarray
 * Solve date: Mon Sep 23 22:30:45 2019
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * Notes: This is a less standard DP. We scan the array and maintains the maxsub and sum.
 *  sum is the candidate of maxsub. If sum is negative, we should discard current sum and
 *  restart calculating sum from current element.
 */

public class DPSecond {
    public int maxSubArray (int[] nums) {
        int maxsub = nums[0];
        int sum = nums[0];

        for (int i=1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            }
            else {
                sum += nums[i];
            }
            maxsub = Math.max(maxsub, sum);
        }
        return maxsub;
    }

    public static void main(String[] args) {
        int[] test = {-2,1,-3,4,-1,2,1,-5,4};
        int res = new DP().maxSubArray(test);
        assert res == 6;
    }
}
