package com.DataProcessing;

public class Transaction {
    private final String transactionId;
    private final long timestamp;
    private final String type;
    private final double amount;

    public Transaction(String transactionId, long timestamp, String type, double amount) {
        this.transactionId = transactionId;
        this.timestamp = timestamp;
        this.type = type;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", timestamp=" + timestamp +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}

