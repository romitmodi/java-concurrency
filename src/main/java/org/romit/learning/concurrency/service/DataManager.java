package org.romit.learning.concurrency.service;

public class DataManager {

    private String dataPacket;
    private boolean isTransfer = true;

    public synchronized void produce(String dataPacket) {
        if (!isTransfer) {
            try {
                wait();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        this.isTransfer = false;
        this.dataPacket = dataPacket;
        notify();

    }

    public synchronized String consume() {
        if (isTransfer) {
            try {
                wait();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        this.isTransfer = true;
        notify();
        return this.dataPacket;
    }
}
