package com.pjw.iw.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 深度优先遍历
 *
 * @author pangjiawei - [Created on 2019/4/15 19:30]
 */
public class DFS {

    public static void search(String name) {
        Set<String> searched = new HashSet<>();
        searched.add(name);

        Stack<String> stack = new Stack<>();
        stack.push(name);

        while (!stack.isEmpty()) {
            String text = stack.peek();
            System.out.println("找到了" + text + "，继续~");
            if (text.endsWith("天")) {
                System.out.println("找到小天了");
                break;
            }

            boolean hasNotSearch = false;
            String[] rs = BFS.relations.get(text);
            for (String r : rs) {
                if (!searched.contains(r)) {
                    searched.add(r);
                    hasNotSearch = true;

                    stack.push(r);
                }
            }

            if (!hasNotSearch) {
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        search("李四");
    }
}
