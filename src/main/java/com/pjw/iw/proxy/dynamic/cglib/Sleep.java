package com.pjw.iw.proxy.dynamic.cglib;

import com.pjw.iw.proxy.Action;

/**
 * @author pangjiawei - [Created on 2019/4/2 10:40]
 */
public class Sleep implements Action {
    @Override
    public void action() {
        System.out.println("sleep...");
    }
}
