package com.pjw.iw.proxy.dynamic.jdk;

import com.pjw.iw.proxy.Action;

/**
 * @author pangjiawei - [Created on 2019/4/2 10:34]
 */
public class Read implements Action {

    @Override
    public void action() {
        System.out.println("read...");
    }
}
