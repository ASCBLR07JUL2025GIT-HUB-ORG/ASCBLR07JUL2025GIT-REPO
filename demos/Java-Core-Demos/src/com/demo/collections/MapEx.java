package com.demo.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapEx {
    public static void main(String[] args) {
        // hashMap();
        treeMap();
    }
    private static void hashMap() {
        // Maps have unique keys and can have duplicate values.
        // The inserted order is not guaranteed in HashMap.
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

        System.out.println("*********************");
        // Collection <Object> values =  map1.values();
        // for (Object value : values) {
        //     System.out.println(value);
        // }
        for(Object value : map1.values()) {
            System.out.println(value);
        }

        Set set = map1.keySet();
        for (Object key : set) {
            System.out.println(key);
        }
    }

    private static void treeMap() {
        // Maps have unique keys and can have duplicate values.
        // The inserted order is not guaranteed in HashMap.
        Map<Object,Object> map1 = new TreeMap<Object,Object>();
        Laptop laptop1 = new Laptop("Inspirion", 10);
        Laptop laptop2 = new Laptop("Thinkpad", 10);
        map1.put("HP", laptop1);
        String laptopBrand = "Lenovo";
        map1.put(laptopBrand, laptop2);
        map1.put("HP", new Laptop("Pavillion", 10));
        map1.put("null", new Laptop("Tuf", 10));
//        map1.put(null, new Laptop("Rog", 10));
//        map1.put(null, new Laptop("MacBook", 10));
        map1.put("null", new Laptop("Vaio", 10));
        map1.put("Sony", new Laptop("Vaio", 10));
        map1.put("Null", new Laptop("Vaio", 10));
        System.out.println(map1);

        System.out.println("*********************");
        // Collection <Object> values =  map1.values();
        // for (Object value : values) {
        //     System.out.println(value);
        // }
        for(Object value : map1.values()) {
            System.out.println(value);
        }

        Set set = map1.keySet();
        for (Object key : set) {
            System.out.println(key);
        }
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