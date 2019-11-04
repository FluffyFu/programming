/*
 * Problem name: container with most water
 * Solve date: Wed Oct 30 21:39:25 2019
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * Notes: The area is determined by two factors horizontal and vertical. The search strategy is to
 *  start with horizontal maximum and shrink horizontal while increasing vertical.
 *
 *  Use two pointer to represent the boundaries of the container. Every time move the lower bar inwards.
 *  Because, the area is determined by the lower bar.
 */

public class TwoPointer {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int area = Math.min(height[i], height[j]) * (j-i);

        while (j > i) {
            if (height[i] >= height[j]) {
                j--;
            }
            else i++;
            area = Math.max(area, Math.min(height[i], height[j]) * (j-i));
        }
        return area;
    }

    public static void main(String[] args) {
        int[] h = {1,8,6,2,5,4,8,3,7};
        TwoPointer obj = new TwoPointer();
        System.out.println(obj.maxArea(h));
    }
}
