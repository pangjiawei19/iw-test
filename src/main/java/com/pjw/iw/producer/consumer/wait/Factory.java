package com.pjw.iw.producer.consumer.wait;

import java.util.LinkedList;
import java.util.Queue;

import com.pjw.iw.producer.consumer.Item;

/**
 * @author pangjiawei - [Created on 2019/4/2 11:41]
 */
public class Factory {

    public static final int MAX_ITEM_COUNT = 10;

    private static Object mutex = new Object();

    private static Queue<Item> items = new LinkedList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Consumer(mutex, items), "consumer-" + i).start();
            new Thread(new Producer(mutex, items), "producer-" + i).start();
        }

    }
}
