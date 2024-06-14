package com.List;

import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        // Demonstrate OrderList
        OrderList<String> orderList = new OrderList<>();
        orderList.add("Order1");
        orderList.add("Order2");
        System.out.println("Order at index 1: " + orderList.get(1));
        orderList.remove(0);
        System.out.println("Size after removal: " + orderList.size());

        // Demonstrate DeliveryRoute
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

        // Demonstrate InventoryCache
        InventoryCache<String, String> cache = new InventoryCache<>(2);
        cache.put("item1", "value1");
        cache.put("item2", "value2");
        System.out.println("Item 1: " + cache.get("item1"));
        cache.put("item3", "value3");
        System.out.println("Item 2: " + cache.get("item2")); // Should be null
        System.out.println("Item 3: " + cache.get("item3"));
    }
}

