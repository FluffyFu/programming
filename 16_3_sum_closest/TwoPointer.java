/*
 * Problem name: 3 sum closest
 * Solve date: Wed Nov  6 21:04:07 2019
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 * Notes: Sort the array first. Loop through the first element. Use two pointer for the 2nd and 3rd
 *  element. Maintain the closest result.
 */

import java.util.Arrays;

public class TwoPointer {
    public int threeSumCloest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];

        for (int i=0; i<nums.length - 2; i++) {
            if (i != 0 && nums[i-1] == nums[i]) continue;

            int l=i+1;
            int r=nums.length - 1;
            while (l < r) {
                int cur = nums[l] + nums[r] + nums[i];
                if (cur < target) {
                    if (Math.abs(cur - target) < Math.abs(res - target)) {
                        res = cur;
                    }
                    l++;
                }
                else if (cur > target) {
                    if (Math.abs(cur - target) < Math.abs(res - target)) {
                        res = cur;
                    }
                    r--;
                }
                else if (cur == target) return target;

            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        TwoPointer obj = new TwoPointer();
        int res = obj.threeSumCloest(nums, target);
        System.out.println(res);
    }
}
