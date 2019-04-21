package com.pjw.iw.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author pangjiawei - [Created on 2019/4/16 14:56]
 */
public class Dijkstra {

    private static final Map<String, Map<String, Integer>> graph = new HashMap<>();

    static {
        Map<String, Integer> map = new HashMap<>();
        map.put("海报", 0);
        map.put("唱片", 5);
        graph.put("乐谱", map);

        map = new HashMap<>();
        map.put("吉他", 15);
        map.put("架子鼓", 20);
        graph.put("唱片", map);

        map = new HashMap<>();
        map.put("吉他", 30);
        map.put("架子鼓", 35);
        map.put("唱片", 4);
        graph.put("海报", map);

        map = new HashMap<>();
        map.put("钢琴", 20);
        graph.put("吉他", map);

        map = new HashMap<>();
        map.put("钢琴", 10);
        graph.put("架子鼓", map);
    }

    public static void find(String src, String target) {
        Map<String, Integer> costs = new HashMap<>();
        Map<String, String> fathers = new HashMap<>();

        Set<String> searched = new HashSet<>();

        Set<String> wait = new HashSet<>();
        searched.add(src);
        for (Map.Entry<String, Integer> entry : graph.get(src).entrySet()) {
            wait.add(entry.getKey());
            fathers.put(entry.getKey(), src);
            costs.put(entry.getKey(), entry.getValue());
        }


        while (!wait.isEmpty()) {
            String obj = getMinPrice(wait, costs);
            wait.remove(obj);
            searched.add(obj);
            if (!graph.containsKey(obj)) {
                continue;
            }
            for (Map.Entry<String, Integer> entry : graph.get(obj).entrySet()) {
                String next = entry.getKey();
                if (!searched.contains(next)) {
                    wait.add(next);
                }

                int cost = entry.getValue();
                int totalCost = costs.get(obj) + cost;

                if (!costs.containsKey(next)
                        || costs.get(next) > totalCost) {
                    costs.put(next, totalCost);
                    fathers.put(next, obj);
                }
            }
        }

        System.out.println("需要花费：" + costs.get(target));
        List<String> link = new ArrayList<>();
        link.add(target);
        String father = fathers.get(target);
        while (father != null) {
            link.add(father);
            father = fathers.get(father);
        }
        for (int i = link.size() - 1; i >= 0; i--) {
            System.out.print(link.get(i) + " --> ");
        }
    }

    private static String getMinPrice(Set<String> wait, Map<String, Integer> costs) {
        int minPrice = 0;
        String minObj = null;
        for (String s : wait) {
            if (minObj == null) {
                if (costs.containsKey(s)) {
                    minObj = s;
                    minPrice = costs.get(s);
                }
            } else {
                int price = costs.getOrDefault(s, Integer.MAX_VALUE);
                if (price < minPrice) {
                    minObj = s;
                    minPrice = price;
                }
            }
        }
        return minObj;
    }

    public static void main(String[] args) {
        find("乐谱", "钢琴");
    }


}
