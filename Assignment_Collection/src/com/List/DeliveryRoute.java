package com.List;

import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DeliveryRoute<E> extends AbstractSequentialList<E> {
    private Node<E> head;
    private int size;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public DeliveryRoute() {
        head = new Node<>(null, null, null);
        head.next = head.prev = head;
        size = 0;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new ListItr(index);
    }

    private class ListItr implements ListIterator<E> {
        private Node<E> lastReturned = head;
        private Node<E> next;
        private int nextIndex;

        ListItr(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            if (index < (size >> 1)) {
                next = head.next;
                for (nextIndex = 0; nextIndex < index; nextIndex++) {
                    next = next.next;
                }
            } else {
                next = head;
                for (nextIndex = size; nextIndex > index; nextIndex--) {
                    next = next.prev;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            next = next.prev;
            lastReturned = next;
            nextIndex--;
            return lastReturned.item;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(E e) {
            if (lastReturned == head) {
                throw new IllegalStateException();
            }
            lastReturned.item = e;
        }

        @Override
        public void add(E e) {
            Node<E> prev = next.prev;
            Node<E> newNode = new Node<>(prev, e, next);
            next.prev = newNode;
            prev.next = newNode;
            nextIndex++;
            size++;
            lastReturned = head;
        }
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
    	
        DeliveryRoute<String> deliveryRoute = new DeliveryRoute<>();
        
        deliveryRoute.add("Point A");
        deliveryRoute.add("Point B");
        deliveryRoute.add("Point C");

        ListIterator<String> iterator = deliveryRoute.listIterator(0);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        iterator = deliveryRoute.listIterator(1);
        System.out.println("Previous point: " + iterator.previous());
    }
}

