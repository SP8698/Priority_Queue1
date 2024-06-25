package com.DataProcessing;

import java.util.concurrent.*;
import java.util.*;

public class TransactionProcessor {
    private final BlockingQueue<Transaction> transactionQueue = new LinkedBlockingQueue<>();
    private final TransactionHistory transactionHistory = new TransactionHistory();

    public void startProcessing() {
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());
        
        producerThread.start();
        consumerThread.start();
    }

    private class Producer implements Runnable {
        @Override
        public void run() {
            Random random = new Random();
            while (true) {
                try {
                    String transactionId = UUID.randomUUID().toString();
                    long timestamp = System.currentTimeMillis();
                    String type = random.nextBoolean() ? "BUY" : "SELL";
                    double amount = 1000 * random.nextDouble();
                    Transaction transaction = new Transaction(transactionId, timestamp, type, amount);
                    
                    transactionQueue.put(transaction);
                    Thread.sleep(100); 
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    private class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Transaction transaction = transactionQueue.take();
                    System.out.println("Processing: " + transaction);
                    transactionHistory.add(transaction);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}

