package org.romit.learning.concurrency;

import org.romit.learning.concurrency.callables.LoggingCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class LoggingApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        List<LoggingCallable> loggingCallables = new ArrayList<>();
        IntStream.range(0, 10).forEach(value -> {
            loggingCallables.add(new LoggingCallable());
        });
        List<Future<Boolean>> futures = service.invokeAll(loggingCallables);
        futures.forEach(booleanFuture -> {
            try {
                System.out.println(booleanFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        Boolean booleanFuture = service.invokeAny(loggingCallables);
        System.out.println(booleanFuture);
        service.shutdown();
    }
}
