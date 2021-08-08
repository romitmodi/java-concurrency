package org.romit.learning.concurrency.runnables;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class MyThread extends Thread {

    private String filePath;

    public MyThread(String path) {
        this.filePath = path;
    }

    public MyThread(String name, String path) {
        super(name);
        this.filePath = path;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Run Method execution started.\n\n");
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Scanner scanner = new Scanner(fileInputStream);) {
            while (scanner.hasNextLine()) {
                System.out.println(Thread.currentThread().getName() + " is reading a line:- " + scanner.nextLine());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
