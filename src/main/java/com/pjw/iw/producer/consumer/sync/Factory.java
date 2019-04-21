package com.pjw.iw.producer.consumer.sync;

import java.util.LinkedList;
import java.util.Queue;

import com.pjw.iw.producer.consumer.Item;

/**
 * @author pangjiawei - [Created on 2019/4/2 11:41]
 */
public class Factory {

    private static Queue<Item> items = new LinkedList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Consumer(items), "consumer-" + i).start();
            new Thread(new Producer(items), "producer-" + i).start();
        }
    }
}
