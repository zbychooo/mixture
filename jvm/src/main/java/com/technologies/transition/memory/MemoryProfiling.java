package com.technologies.transition.memory;

import java.util.ArrayList;
import java.util.List;

public class MemoryProfiling {

	public static void main(String[] args) throws InterruptedException {
		
		List<MyLargeObject> myLargeObjects = new ArrayList<MyLargeObject>();
		
		while (true) {
			System.out.println("hello");
			Thread.sleep(1000);
			myLargeObjects.add(new MyLargeObject());
		}
		
	}
	
}
