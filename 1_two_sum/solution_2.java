/**
 * Problem number: 1
 * Name: two sum
 * Solve Date: 2019/09/04
 * Notes: hash map 
 * time complexity: O(n)
 * space complexity: O(n)? Difference between hashmap and hashtable?
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]), i};
            }
            else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No two sum solution")
    }

