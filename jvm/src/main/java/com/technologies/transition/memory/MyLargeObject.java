package com.technologies.transition.memory;

import java.util.ArrayList;
import java.util.List;

public class MyLargeObject {

	List<Integer> internalList = new ArrayList<Integer>();
	
	public MyLargeObject() {
		for (int i = 0; i < 10e5; i++) {
			internalList.add(i);
		}
	}
	
	public MyLargeObject(double size) {
		for (int i = 0; i < size; i++) {
			internalList.add(i);
		}
	}
	
}
