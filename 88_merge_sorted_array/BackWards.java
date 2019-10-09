/*
 * Problem name: Merge Sorted Array
 * Solve date: Tue Oct  8 22:28:37 2019
 * Time Complexity: O(M + N)
 * Space Complexity: O(1)
 * Notes: Think this backwards. Instead of making the sorted array from small to large, create it from large to
 *  small to avoid shifting elements. Use A > B ? C : D idiom and --.
 */

public class BackWards {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n -1;
        m = m-1;
        n = n-1;
        while (m >= 0 && n >= 0) {
            nums1[k--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (n >= 0) {
            nums1[k--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5};
        BackWards bk = new BackWards();

        bk.merge(nums1, 3, nums2, 2);
        for (int i : nums1) {
            System.out.println(i);
        }

        int[] nums3 = {3, 4, 0, 0};
        int[] nums4 = {1, 2};

        bk.merge(nums3, 2, nums4, 2);
        for (int i : nums3) {
            System.out.println(i);
        }
    }
}
