package com.pjw.iw.magic;

import java.util.Stack;

public class Test3 {

    public static void main(String[] args) {
        System.out.println(calculate(""));
    }

    public static int calculate(String text) {
        Stack<String> stack = new Stack<>();
        int num = 0;

        for (int i = 0; i < text.length(); i++) {
            char word = text.charAt(i);
            if (word == ' ') {
            } else if (word >= '0' && word <= '9') {
                int realNum = word - '0';
                num = 10 * num + realNum;
            } else {
                pushNum(stack, num);
                stack.push(String.valueOf(word));
                num = 0;
            }
        }

        pushNum(stack, num);

        return getNum(stack);
    }

    public static void pushNum(Stack<String> stack, int num) {
        if (!stack.isEmpty()) {
            String top = stack.peek();
            if (top.equals("*") || top.equals("/")) {
                stack.pop();
                int oldNum = Integer.parseInt(stack.pop());
                num = top.equals("*") ? oldNum * num : oldNum / num;
            }
        }
        stack.push(String.valueOf(num));
    }

    public static int getNum(Stack<String> stack) {
        int result = 0;

        int oldNum = Integer.parseInt(stack.pop());
        while (!stack.isEmpty()) {
            String opt = stack.pop();

            switch (opt) {
                case "+": {
                    result = oldNum + result;
                    break;
                }
                case "-": {
                    result = oldNum - result;
                    break;
                }
                default: {
                    oldNum = Integer.parseInt(opt);
                    break;
                }
            }
        }

        return result + oldNum;
    }
}
