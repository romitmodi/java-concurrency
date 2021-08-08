package org.romit.learning.concurrency;

import org.romit.learning.concurrency.runnables.Consumer;
import org.romit.learning.concurrency.runnables.Producer;
import org.romit.learning.concurrency.service.DataManager;

public class ProducerConsumerApplication {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();
        new Thread(new Producer(dataManager)).start();
        new Thread(new Consumer(dataManager)).start();
    }
}
