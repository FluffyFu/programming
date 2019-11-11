/*
 * Problem name: 4 sum
 * Solve date: Sun Nov 10 20:48:15 2019
 * Time Complexity: O(N^3)
 * Space Complexity: O(1)
 * Notes: Sort the array first, loop through a and b (avoid duplicates). Use two pointer to find c and d.
 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TwoPointer {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (nums.length < 4) return ans;
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            if (i!=0 && nums[i-1] == nums[i]) continue;
            for (int j=i+1; j<nums.length-2; j++) {
                if (j!=i+1 && nums[j-1] == nums[j]) continue;
                int l = j+1;
                int r = nums.length - 1;
                while (l < r) {
                    if (nums[i] + nums[j] + nums[l] + nums[r] < target) {
                        while(l < r && nums[l] == nums[l+1]) l++;
                        l++;
                    }
                    else if (nums[i] + nums[j] + nums[l] + nums[r] > target) {
                        while (l < r && nums[r] == nums[r-1]) r--;
                        r--;
                    }
                    else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l+1]) l++;
                        l++;
                        while (l < r && nums[r] == nums[r-1]) r--;
                        r--;
                    }
                }
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        int[] nums = {-7,-5,0,7,1,1,-10,-2,7,7,-2,-6,0,-10,-5,7,-8,5};
        int target = 28;
        TwoPointer obj = new TwoPointer();
        List<List<Integer>> res = obj.fourSum(nums, target);
        for (List<Integer> a : res) {
            for (int subres : a) {
                System.out.println(subres);
            }
        }

    }
}
