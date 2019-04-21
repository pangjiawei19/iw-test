package com.pjw.iw.structure;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author pangjiawei - [Created on 2019/4/17 18:11]
 */
public class StackByQueue<T> {

    private Queue<T> q1 = new ArrayDeque<>();
    private Queue<T> q2 = new ArrayDeque<>();

    public void push(T t) {
        Queue<T> q = q1.isEmpty() ? q2 : q1;
        q.offer(t);
    }

    public T pop() {
        if (q1.isEmpty() && q2.isEmpty()) {
            return null;
        }

        Queue<T> q;
        Queue<T> nq;
        if (q1.isEmpty()) {
            q = q2;
            nq = q1;
        } else {
            q = q1;
            nq = q2;
        }

        int count = q.size() - 1;
        for (int i = 0; i < count; i++) {
            nq.offer(q.poll());
        }

        return q.poll();
    }

    public boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void main(String[] args) {
        StackByQueue<Integer> stack = new StackByQueue<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
