package com.bektur;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cache myCache = CacheFactory.createCache("LRU", 2);
        Cache fifoCache = CacheFactory.createCache("FIFO", 3);

        myCache.put("A", 1);
        myCache.put("B", 6);
        myCache.put("C", 4);
        myCache.put("D", 2);

        fifoCache.put("A", 1);
        fifoCache.put("B", 6);
        fifoCache.put("C", 4);
        fifoCache.put("D", 2);
        fifoCache.put("E", 6);
        System.out.println("Here are my LRU cache's: ");
        System.out.println("A: " + myCache.get("A"));
        System.out.println("B: " + myCache.get("B"));
        System.out.println("C: " + myCache.get("C"));
        System.out.println("D: " + myCache.get("D"));

        System.out.println("Here are my FIFO cache's: ");
        System.out.println("A: " + fifoCache.get("A"));
        System.out.println("B: " + fifoCache.get("B"));
        System.out.println("C: " + fifoCache.get("C"));
        System.out.println("D: " + fifoCache.get("D"));
        System.out.println("E: " + fifoCache.get("E"));
    }
}