package com.pjw.iw.string.match.brackets;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author pangjiawei - [Created on 2019/4/11 20:19]
 */
public class BracketsMatch {

    public static final Map<Character, Character> brackets = new HashMap<>();

    static {
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');
    }

    public static boolean isMatch(String text) {
        if (text == null) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : text.toCharArray()) {
            if (brackets.containsValue(c)) {
                stack.push(c);
            } else if (brackets.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != brackets.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String text = "sdlfkj(((((";

        System.out.println(isMatch(text));
    }
}
