package com.technologies.transition.memory;

import java.util.ArrayList;
import java.util.List;

public class InvisibleMemory {
	
	public void execute() throws InterruptedException {

		Thread.sleep(5000);

		try {
			List<Integer> customList = createLargeList();
	
		} catch (Exception e) {
			e.printStackTrace();
		}

//		System.gc();
		
		while (true) {
			System.out.println("hello");
			Thread.sleep(1000);
		}
	}

	public static List<Integer> createLargeList() {
		List<Integer> customList = new ArrayList<Integer>();
		for (int i = 0; i < 10e6; i++) {
			customList.add(i);
		}
		return customList;
	}
	
}
