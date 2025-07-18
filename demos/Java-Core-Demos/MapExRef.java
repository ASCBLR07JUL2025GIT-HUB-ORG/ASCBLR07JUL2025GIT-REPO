package com.demo.collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExRef {
	public static void main(String[] args) {
		m1();
		m2();
	}

	private static void m2() {
		Map map = new HashMap();
		Laptop sonyLaptop = new Laptop("sony", 123f);
		map.put(sonyLaptop.laptopName, sonyLaptop);
		Laptop dell = new Laptop("dell", 123f);
		map.put(dell.laptopName, dell);
		Laptop mac = new Laptop("mac", 123f);
		map.put(mac.laptopName, mac);

		// iterate the map
		Iterator iterator = map.values().iterator();
		while (iterator.hasNext()) {
			Object object = iterator.next();
			System.out.println(object);
		}

		// code to iterate and display all the keys.
//		Iterator iterator2 = map.keySet().iterator();
		Set set =  map.keySet();
		Iterator iterator2 = set.iterator();
		while (iterator2.hasNext()) {
			System.out.println(iterator2.next());
		}

		// code to iterate and display the key & value pairs together.
		for (Object valueObject : map.entrySet()) {
			System.err.println(valueObject);
		}
	}

	private static void m1() {
//		Map map = new HashMap<>();
//		map = new TreeMap<>();
		HashMap<Object, Object> map1 = new HashMap<>();
		Laptop laptop500 = new  Laptop("k1",10);
//		Laptop laptop600 = laptop500;
		Laptop laptop600 =  new  Laptop("k1",10);
//		identical
		if(laptop600 == laptop500) {
			System.out.println("same instance");
		}
		
		map1.put(new Laptop("k1",10), new Laptop("v1",10) );
		map1.put(laptop500, new Laptop("v2",10) );
		map1.put(laptop500, new Laptop("v3",10) );
		System.out.println(map1);
		
		Map map = new HashMap();
		Laptop sonyLaptop = new Laptop("sony", 123f);
		map.put(sonyLaptop.laptopName, sonyLaptop);
		Laptop dell = new Laptop("dell", 123f);
		map.put(dell.laptopName, dell);
		Laptop mac = new Laptop("mac", 123f);
		map.put(null, mac);
		Laptop lenova = new Laptop("lenova", 123f);
		map.put(null, lenova);
		map.put("lap1", null);
		map.put("lap2", null);
		System.out.println(map);
		// System.err.println(map.get("sony"));
		// System.err.println(map.containsKey("sony"));

	}
}

class Laptop {

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	// Fields
	public String laptopName;
	public float price;

	// Default constructor
	public Laptop(String plaptopName, float pprice) {
		laptopName = plaptopName;
		price = pprice;
	}

	public Laptop() {

	}

	@Override
	public String toString() {
		return "Laptop [laptopName=" + laptopName + ", price=" + price + "]";
	}

}
