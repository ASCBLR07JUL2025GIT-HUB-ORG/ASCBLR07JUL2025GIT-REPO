package com.demo.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapEx {
    public static void main(String[] args) {
        m1();
    }
    private static void m1() {
        // Maps have unique keys and can have duplicate values.
        Map<Object,Object> map1 = new HashMap<Object,Object>();
        Laptop laptop1 = new Laptop("Inspirion", 10);
        Laptop laptop2 = new Laptop("Thinkpad", 10);
        map1.put("HP", laptop1);
        String laptopBrand = "Lenovo";
        map1.put(laptopBrand, laptop2);
        map1.put("HP", new Laptop("Pavillion", 10));
        map1.put("null", new Laptop("Tuf", 10));
        map1.put(null, new Laptop("Rog", 10));
        map1.put(null, new Laptop("MacBook", 10));
        map1.put("null", new Laptop("Vaio", 10));
        map1.put("Sony", new Laptop("Vaio", 10));
        System.out.println(map1);
    }
}


class Laptop {

 String laptopName;
 float price;

 // constructor
 public Laptop(String laptopNameParam, float priceParam) {
     laptopName = laptopNameParam;
     price = priceParam;
 }

    @Override
    public String toString() {
        return "Laptop [laptopName=" + laptopName + ", price=" + price + "]";
    }
}