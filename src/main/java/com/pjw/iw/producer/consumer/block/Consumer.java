package com.pjw.iw.producer.consumer.block;

import java.util.Queue;

import com.pjw.iw.producer.consumer.Item;

/**
 * @author pangjiawei - [Created on 2019/4/2 11:45]
 */
public class Consumer implements Runnable {

    private final Queue<Item> items;

    public Consumer(Queue<Item> items) {
        this.items = items;
    }

    public void consume() throws InterruptedException {
        while (true) {
            if (!items.isEmpty()) {
                items.poll();
                System.out.println(Thread.currentThread().getName() + " consume, size: " + items.size());
            }

            Thread.sleep(500);
        }
    }

    @Override
    public void run() {
        try {
            consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
