/*
 * Problem name: maximum subarray
 * Solve date: Mon Sep 23 22:16:34 2019
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * Notes: DP solution. Two relations:
 *  MaxSub(i) = max(MaxSub(i-1), MaxEnd(i)),
 *  MaxEnd(i) = max(nums[i], nums[i] + MaxEnd(i-1))
 *
 *  where MaxSub(i): maximum subarray of the first i elements.
 *        MaxEnd(i): maximum subarray that contains the i-th element.
 *
 *  We only need to maintain these two quantities while scanning the array.
 */
public class DP {
    public int maxSubArray(int[] nums) {
        int maxsub = nums[0];
        int maxend = nums[0];

        for (int i=1; i < nums.length; i++) {
            maxend = Math.max(maxend+nums[i], nums[i]);
            maxsub = Math.max(maxsub, maxend);
        }
        return maxsub;
    }

    public static void main(String[] args) {
        int[] test = {-2,1,-3,4,-1,2,1,-5,4};
        int res = new DP().maxSubArray(test);
        assert res == 6;
    }
}
