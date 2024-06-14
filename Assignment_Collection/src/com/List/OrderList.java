package com.List;

import java.util.AbstractList;

public class OrderList<E> extends AbstractList<E> {
    private Object[] orders;
    private int size = 0;

    public OrderList() {
        orders = new Object[10]; // initial capacity
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) orders[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E e) {
        if (size == orders.length) {
            resize();
        }
        orders[size++] = e;
        return true;
    }

    @Override
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
		E oldValue = (E) orders[index];

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(orders, index + 1, orders, index, numMoved);
        }
        orders[--size] = null;
        return oldValue;
    }

    private void resize() {
        Object[] newOrders = new Object[orders.length * 2];
        System.arraycopy(orders, 0, newOrders, 0, orders.length);
        orders = newOrders;
    }

    public static void main(String[] args) {
    	
        OrderList<String> orderList = new OrderList<>();
        orderList.add("Order1");
        orderList.add("Order2");
        System.out.println("Order at index 1: " + orderList.get(1));
        orderList.remove(0);
        System.out.println("Size after removal: " + orderList.size());
    }
}
