package com.pjw.iw.producer.consumer.wait;

import java.util.Queue;

import com.pjw.iw.producer.consumer.Item;

/**
 * @author pangjiawei - [Created on 2019/4/2 11:36]
 */
public class Producer implements Runnable {

    private final Object mutex;

    private Queue<Item> items;

    public Producer(Object mutex, Queue<Item> items) {
        this.mutex = mutex;
        this.items = items;
    }

    public void produce() throws InterruptedException {
        while (true) {
            synchronized (mutex) {
                while (items.size() >= Factory.MAX_ITEM_COUNT) {
                    mutex.wait();
                }

                Item item = Item.create();
                items.offer(item);
                System.out.println(Thread.currentThread().getName() + " produce, size: " + items.size());
                mutex.notifyAll();

                Thread.sleep(500);
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
