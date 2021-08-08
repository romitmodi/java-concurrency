package org.romit.learning.concurrency.callables;

import java.util.concurrent.Callable;

public class LoggingCallable implements Callable<Boolean> {

    @Override
    public Boolean call() {
        System.out.println(Thread.currentThread().getName() + " " + LoggingCallable.class.getClass());
        return true;
    }
}
