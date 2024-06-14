package com.List;

import java.util.HashMap;
import java.util.Map;

public class InventoryCache<K, V> {
    private final int capacity;
    private Map<K, Node<K, V>> map;
    private Node<K, V> head, tail;

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev, next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public InventoryCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(K key, V value) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            Node<K, V> newNode = new Node<>(key, value);
            map.put(key, newNode);
            addNode(newNode);
            if (map.size() > capacity) {
                Node<K, V> tail = popTail();
                map.remove(tail.key);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addNode(Node<K, V> node) {
        node.prev = null;
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
    }

    private void moveToHead(Node<K, V> node) {
        if (node == head) {
            return;
        }
        removeNode(node);
        addNode(node);
    }

    private void removeNode(Node<K, V> node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private Node<K, V> popTail() {
        Node<K, V> res = tail;
        removeNode(tail);
        return res;
    }

    public static void main(String[] args) {
        InventoryCache<String, String> cache = new InventoryCache<>(2);
        cache.put("item1", "value1");
        cache.put("item2", "value2");
        System.out.println("Item 1: " + cache.get("item1"));
        cache.put("item3", "value3");
        System.out.println("Item 2: " + cache.get("item2")); 
        System.out.println("Item 3: " + cache.get("item3"));
    }
}

