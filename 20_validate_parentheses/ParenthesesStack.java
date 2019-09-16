/*
 * Problem name: Validate Parentheses
 * Solve date: Sun Sep 15 22:32:37 2019
 * Time Complexity: O(N)
 * Space Complexity: O(N) worst case scenario
 * Notes: Use stack. Scan the string, if come across a left side parentheses push
 *  it into the stack. If come across a right size parentheses, pop an element from
 *  the stack and check if they match.
 */

import java.util.Stack;

public class ParenthesesStack {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++) {
            char current = s.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            }
            else if (current == ')' || current == ']' || current == '}') {
                if (stack.size() == 0 || getRightSide(stack.pop()) != current) {
                    return false;
                }
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    private char getRightSide(char s) {
        char right;
        if (s == '(') {
            return ')';
        }
        else if (s == '[') {
            return ']';
        }
        else {
            return '}';
        }
    }

    public static void main(String[] args) {
        String test = "()]";
        boolean res = new ParenthesesStack().isValid(test);
        System.out.println(res);
    }

}
