package org.romit.learning.concurrency;

import org.romit.learning.concurrency.runnables.MyThread;

public class ReadFileConcurrentlyViaThread {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1 = new MyThread("C:\\Users\\romit\\Work\\codebase\\Java\\java-concurrency\\src\\main\\resources\\sample.txt");
        MyThread myThread2 = new MyThread("C:\\Users\\romit\\Work\\codebase\\Java\\java-concurrency\\src\\main\\resources\\sample.txt");
        MyThread myThread3 = new MyThread("C:\\Users\\romit\\Work\\codebase\\Java\\java-concurrency\\src\\main\\resources\\sample.txt");
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread1.join();
        myThread2.join();
        myThread3.join();
        System.out.print("\n\nMain Thread execution completed");
    }
}

