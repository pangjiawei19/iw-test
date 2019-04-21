package com.pjw.iw.graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 广度优先遍历
 *
 * @author pangjiawei - [Created on 2019/4/15 19:30]
 */
public class BFS {

    static final Map<String, String[]> relations = new HashMap<>();

    static {
        relations.put("李四", new String[]{"张三", "王五", "六二", "田七"});
        relations.put("张三", new String[]{"李四", "王五", "赵四", "欧阳天"});
        relations.put("王五", new String[]{"李四", "张三", "西门吹", "年二头"});
        relations.put("六二", new String[]{"李四"});
        relations.put("田七", new String[]{"李四"});
        relations.put("赵四", new String[]{"张三", "林大壮"});
        relations.put("欧阳天", new String[]{"张三"});
        relations.put("西门吹", new String[]{"王五"});
        relations.put("年二头", new String[]{"王五"});
        relations.put("林大壮", new String[]{"赵四"});
    }

    public static void search(String name) {

        if (!relations.containsKey(name)) {
            System.out.println("没这个人");
            return;
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(name);
        Set<String> searchedName = new HashSet<>();

        boolean isFind = false;
        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (searchedName.contains(s)) {
                continue;
            }
            if (s.endsWith("天")) {
                System.out.println("找到小天了");
                isFind = true;
                break;
            } else {
                searchedName.add(s);
                System.out.println("找到了" + s + "，继续~");
                for (String rs : relations.get(s)) {
                    queue.offer(rs);
                }
            }
        }

        if (!isFind) {
            System.out.println("没有找到");
        }

    }

    public static void main(String[] args) {
//        search("张三");
//        search("李四");
        search("年二头");
    }
}








