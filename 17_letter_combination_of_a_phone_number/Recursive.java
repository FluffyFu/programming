/*
 * Problem name: All combination of a telephone number.
 * Solve date: Thu Nov  7 21:15:52 2019
 * Time Complexity: O(3^N)
 * Space Complexity: O(3^N)
 * Notes: Recursively solve the problem. Whenever a new number is added, the possible results is the
 *  sum of the original results combine with all the letters corresponds to that number.
 */

import java.util.*;

public class Recursive {
    private static final String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        else return combinations(digits);
    }

    private List<String> combinations(String digits) {
        if (digits.length() == 0) {
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        else {
            List<String> prev = combinations(digits.substring(1));
            List<String> cur = new ArrayList<>();
            String letters = map[Integer.parseInt(digits.substring(0, 1))];
            for (int i=0; i<letters.length(); i++) {
                List<String> temp = new ArrayList<>();
                for (int j=0; j<prev.size(); j++) {
                    temp.add(letters.substring(i,i+1) + prev.get(j));
                }
                cur.addAll(temp);
            }
            return cur;
        }
    }
    public static void main(String[] args) {
        String test = "23";
        Recursive obj = new Recursive();
        List<String> res = obj.letterCombinations(test);
        for (int i=0; i<res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
