package com.DataProcessing;

import java.util.*;
import java.util.concurrent.locks.*;

public class TransactionHistory implements List<Transaction> {
    private final List<Transaction> transactions;
    private final ReentrantLock lock = new ReentrantLock();

    public TransactionHistory() {
        this.transactions = new ArrayList<>();
    }

    @Override
    public int size() {
        lock.lock();
        try {
            return transactions.size();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        try {
            return transactions.isEmpty();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean contains(Object o) {
        lock.lock();
        try {
            return transactions.contains(o);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Iterator<Transaction> iterator() {
        lock.lock();
        try {
            return new ArrayList<>(transactions).iterator();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Object[] toArray() {
        lock.lock();
        try {
            return transactions.toArray();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public <T> T[] toArray(T[] a) {
        lock.lock();
        try {
            return transactions.toArray(a);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean add(Transaction transaction) {
        lock.lock();
        try {
            return transactions.add(transaction);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean remove(Object o) {
        lock.lock();
        try {
            return transactions.remove(o);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        lock.lock();
        try {
            return transactions.containsAll(c);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean addAll(Collection<? extends Transaction> c) {
        lock.lock();
        try {
            return transactions.addAll(c);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends Transaction> c) {
        lock.lock();
        try {
            return transactions.addAll(index, c);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        lock.lock();
        try {
            return transactions.removeAll(c);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        lock.lock();
        try {
            return transactions.retainAll(c);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void clear() {
        lock.lock();
        try {
            transactions.clear();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Transaction get(int index) {
        lock.lock();
        try {
            return transactions.get(index);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Transaction set(int index, Transaction element) {
        lock.lock();
        try {
            return transactions.set(index, element);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void add(int index, Transaction element) {
        lock.lock();
        try {
            transactions.add(index, element);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Transaction remove(int index) {
        lock.lock();
        try {
            return transactions.remove(index);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int indexOf(Object o) {
        lock.lock();
        try {
            return transactions.indexOf(o);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        lock.lock();
        try {
            return transactions.lastIndexOf(o);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public ListIterator<Transaction> listIterator() {
        lock.lock();
        try {
            return new ArrayList<>(transactions).listIterator();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public ListIterator<Transaction> listIterator(int index) {
        lock.lock();
        try {
            return new ArrayList<>(transactions).listIterator(index);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public List<Transaction> subList(int fromIndex, int toIndex) {
        lock.lock();
        try {
            return new ArrayList<>(transactions.subList(fromIndex, toIndex));
        } finally {
            lock.unlock();
        }
    }
}

