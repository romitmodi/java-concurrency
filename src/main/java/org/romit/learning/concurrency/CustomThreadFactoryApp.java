package org.romit.learning.concurrency;

import org.romit.learning.concurrency.callables.LoggingCallable;
import org.romit.learning.concurrency.custom.api.CustomThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.IntStream;

public class CustomThreadFactoryApp {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3, new CustomThreadFactory());

        IntStream.range(0, 6).forEach(value -> {
            service.submit(new LoggingCallable());
        });
    }
}
