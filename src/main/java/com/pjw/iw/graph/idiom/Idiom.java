package com.pjw.iw.graph.idiom;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author pangjiawei - [Created on 2019/4/18 18:18]
 */
public class Idiom {

    private static Set<String> buckets = new HashSet<>();

    static {
        buckets.add("法外施仁");
        buckets.add("仁者之心");
        buckets.add("仁浆义粟");
        buckets.add("粟红贯朽");
        buckets.add("粟遇红灯");
        buckets.add("灯红酒绿");
        buckets.add("朽木死灰");
        buckets.add("壮志凌云");
        buckets.add("约定俗成");
    }

    public static void link(String start, String end) {
        Set<String> searched = new HashSet<>();
        searched.add(start);

        Stack<String> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            String text = stack.peek();
            System.out.println(text);
            if (text.equals(end)) {
                System.out.println("finish");
                break;
            }

            boolean hasNotSearch = false;
            for (String next : getNextSet(text)) {
                if (!searched.contains(next)) {
                    searched.add(next);
                    hasNotSearch = true;

                    stack.push(next);
                }
            }

            if (!hasNotSearch) {
                stack.pop();
            }
        }
    }

    public static Set<String> getNextSet(String text) {
        String t = String.valueOf(text.charAt(text.length() - 1));
        return buckets.stream()
                .filter(s -> s.startsWith(t))
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        link("法外施仁", "朽木死灰");
    }
}
