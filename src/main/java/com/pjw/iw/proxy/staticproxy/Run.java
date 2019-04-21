package com.pjw.iw.proxy.staticproxy;

import com.pjw.iw.proxy.Action;

/**
 * @author pangjiawei - [Created on 2019/4/2 10:30]
 */
public class Run implements Action {

    @Override
    public void action() {
        System.out.println("run...");
    }
}
