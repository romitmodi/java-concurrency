package org.romit.learning.concurrency.runnables;

import org.romit.learning.concurrency.service.DataManager;

import java.util.stream.IntStream;

public class Producer implements Runnable {

    private DataManager dataManager;

    public Producer(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void run() {
        IntStream.range(1, 11).forEachOrdered(value -> {
            this.dataManager.produce(value + "");
            System.out.println(Thread.currentThread().getName() + " has produced " + value);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Producer job is done");
    }
}
