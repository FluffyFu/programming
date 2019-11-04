/*
 * Problem name: 3 SUM
 * Solve date: Sun Nov  3 20:10:06 2019
 * Time Complexity: O(N**2)
 * Space Complexity: O(N)
 * Notes: Loop through the first element a. Use hashmap to solve b + c = -a in O(N) time.
 *  Things need to take care is avoiding duplicates in two places:
 *  1. avoid duplicate a by sorting the entire the array first to make sure every time only one value of a is chosen.
 *  2. when doing the haspmap checking if both b and c are in the map, skip this match.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

public class ConvertToTwoSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;

        Arrays.sort(nums);
        int cur = 0;

        while (cur < nums.length) {
            // skip duplicate a.
            if (cur != 0 && nums[cur] == nums[cur-1]) {
                cur++;
                continue;
            }
            Set<Integer> collect = new HashSet<Integer>();

            int i = cur + 1;
            while (i < nums.length){

                // deal with b != c
                if (collect.contains(nums[i]) == false && collect.contains(-nums[cur]-nums[i])) {
                    res.add(Arrays.asList(nums[cur], nums[i], -nums[cur]-nums[i]));
                }
                // deal with the case b = c.
                if (collect.contains(nums[i]) == true && nums[i] == -nums[cur] - nums[i]) {
                    int duplicate = nums[i];
                    res.add(Arrays.asList(nums[cur], nums[i], nums[i]));
                    while (i < nums.length && duplicate == nums[i]) i++;
                    continue;
                }
                if (i < nums.length) collect.add(nums[i]);
                i++;
            }

            cur++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {-1, 0, 1, 2, -1, -4};
        int[] test2 = {0, 0, 0};
        ConvertToTwoSum obj = new ConvertToTwoSum();
        List<List<Integer>> res = obj.threeSum(test);
        for (List<Integer> singleRes : res) {
            for (int num : singleRes) {
                System.out.println(num);
            }
        }
    }
}
