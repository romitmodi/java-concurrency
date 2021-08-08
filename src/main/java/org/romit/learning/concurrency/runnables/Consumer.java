package org.romit.learning.concurrency.runnables;

import org.romit.learning.concurrency.service.DataManager;

public class Consumer implements Runnable {

    private DataManager dataManager;

    public Consumer(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void run() {
        String consumeData = "";
        while (!(consumeData = dataManager.consume()).equalsIgnoreCase("10")) {
            System.out.println(Thread.currentThread().getName() + " has consumed " + consumeData);
        }
        System.out.println("Consumer job is done");
    }
}
