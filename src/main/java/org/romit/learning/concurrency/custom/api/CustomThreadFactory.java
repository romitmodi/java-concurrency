package org.romit.learning.concurrency.custom.api;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {
    private static int count = 1;

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("Thread created from custom ThreadFactory-" + count);
        count++;
        return thread;
    }
}
