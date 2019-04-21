package com.pjw.iw.proxy.staticproxy;

import java.util.Random;

import com.pjw.iw.proxy.Action;

/**
 * @author pangjiawei - [Created on 2019/4/2 10:30]
 */
public class RunProxy implements Action {

    private Run run;

    public RunProxy(Run run) {
        this.run = run;
    }

    @Override
    public void action() {
        if (new Random().nextBoolean()) {
            System.out.println("start run");
            run.action();
        } else {
            System.out.println("no heart~");
        }
    }

    public static void main(String[] args) {
        Action run = new RunProxy(new Run());
        run.action();
    }
}
