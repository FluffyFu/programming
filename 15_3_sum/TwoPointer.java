/*
 * Problem name: 3 SUM
 * Solve date: Mon Nov  4 08:30:20 2019
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 * Notes: First sort the array to avoid having duplicated a. Since the array is sorted, we can use two pointer to find b and c.
 *  Remember to avoid duplicates using two pointer.
 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class TwoPointer {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++) {
            if (i != 0 && nums[i-1] == nums[i]) continue;

            int sum = nums[i];
            int l = i+1;
            int r = nums.length - 1;

            while(l < r) {
                if (nums[l] + nums[r] < -sum) {
                    l++;
                }
                else if (nums[l] + nums[r] > -sum) {
                    r--;
                }
                else if (nums[l] + nums[r] == -sum) {
                    res.add(Arrays.asList(sum, nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l+1]) l++;
                    while (l < r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] test = {-1, 0, 1, 2, -1, -4};
        int[] test2 = {0, 0, 0};
        TwoPointer obj = new TwoPointer();
        List<List<Integer>> res = obj.threeSum(test2);
        for (List<Integer> singleRes : res) {
            for (int num : singleRes) {
                System.out.println(num);
            }
        }
    }
}
