package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class J20_Valid_Parentheses {
    public boolean IsValid(String s) {
        //{}[]()
        //define { [ ( is insert } ] ) is output
        if ("".equals(s)) return true;
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else {
                //if first char is }])
                if (stack.isEmpty()) {
                    return false;
                }
                char removeCh = stack.pop();
                if (removeCh != match(ch)) {
                    return false;
                }
            }
        }
        //not close
        if (!stack.isEmpty()) return false;

        return true;
    }

    public char match(char ch) {
        if (ch == '}') {
            return '{';
        } else if (ch == ')') {
            return '(';
        } else if (ch == ']') {
            return '[';
        }
        return ']';
    }

    public static void main(String[] args) {
        String s = "{}[]({[]()})";
        System.out.println(new J20_Valid_Parentheses().IsValid(s));
    }
}