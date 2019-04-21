package com.pjw.iw.producer.consumer.sync;

import java.util.Queue;

import com.pjw.iw.producer.consumer.Item;
import com.pjw.iw.producer.consumer.wait.Factory;

/**
 * @author pangjiawei - [Created on 2019/4/2 11:36]
 */
public class Producer implements Runnable {

    private final Queue<Item> items;

    public Producer(Queue<Item> items) {
        this.items = items;
    }

    public void produce() throws InterruptedException {
        while (true) {
            synchronized (items) {
                if (items.size() < Factory.MAX_ITEM_COUNT) {
                    items.offer(Item.create());
                    System.out.println(Thread.currentThread().getName() + " produce, size: " + items.size());
                    Thread.sleep(500);
                }

            }
        }
    }


    @Override
    public void run() {
        try {
            produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
