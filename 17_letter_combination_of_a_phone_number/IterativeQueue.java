/*
 * Problem name: All combinations of a phone number
 * Solve date: Sun Nov 10 20:08:11 2019
 * Time Complexity: O(3^N)
 * Space Complexity: O(3^N)
 * Notes: Use a queue to store current results. When a new number comes in, pop out each content in the queue,
 *  and the current letters, then push it back to queue.
 */

import java.util.LinkedList;
import java.util.List;

public class IterativeQueue {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.length() == 0) return ans;
        ans.add("");
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i=0; i<digits.length(); i++) {
            String candidates = map[Character.getNumericValue(digits.charAt(i))];
            while(ans.peek().length() == i) {
                String cur = ans.remove();
                for(char c : candidates.toCharArray()) {
                    ans.add(cur + c);
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        String test = "23";
        IterativeQueue obj = new IterativeQueue();
        List<String> res = obj.letterCombinations(test);
        for (int i=0; i<res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
