package com.pjw.iw.producer.consumer;

/**
 * @author pangjiawei - [Created on 2019/4/2 11:37]
 */
public class Item {

    private Item() {
    }

    public static Item create() {
        return new Item();
    }
}
