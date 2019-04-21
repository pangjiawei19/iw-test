package com.pjw.iw.structure;

import java.util.Stack;

/**
 * @author pangjiawei - [Created on 2019/4/17 17:07]
 */
public class QueueByStack<T> {

    private Stack<T> s1 = new Stack<>();
    private Stack<T> s2 = new Stack<>();

    public void offer(T t) {
        s1.push(t);
    }

    public T poll() {
        if (s1.isEmpty() && s2.isEmpty()) {
            return null;
        }

        if (!s2.isEmpty()) {
            return s2.pop();
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        return s2.pop();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }


    public static void main(String[] args) {
        QueueByStack<Integer> queue = new QueueByStack<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

}
