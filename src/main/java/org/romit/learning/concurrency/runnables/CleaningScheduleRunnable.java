package org.romit.learning.concurrency.runnables;

import java.util.stream.IntStream;

public class CleaningScheduleRunnable implements Runnable {

    @Override
    public void run() {
        IntStream.range(0, 5).forEach(value -> {
            System.out.println("Hi, i am deleting the file with Id " + value);
        });
    }
}
