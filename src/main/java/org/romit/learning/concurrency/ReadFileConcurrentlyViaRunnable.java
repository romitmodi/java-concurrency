package org.romit.learning.concurrency;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ReadFileConcurrentlyViaRunnable {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + " Run Method execution started.\n\n");
            try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\romit\\Work\\codebase\\Java\\java-concurrency\\src\\main\\resources\\sample.txt");
                 Scanner scanner = new Scanner(fileInputStream);) {
                while (scanner.hasNextLine()) {
                    System.out.println(Thread.currentThread().getName() + " is reading a line:- " + scanner.nextLine());
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(runnable);
        thread1.join();
    }
}
