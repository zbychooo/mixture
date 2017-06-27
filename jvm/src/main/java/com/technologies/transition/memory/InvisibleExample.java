package com.technologies.transition.memory;

public class InvisibleExample {
	
	public static void main(String[] args) {
		InvisibleMemory invisibleMemory = new InvisibleMemory();
		try {
			invisibleMemory.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
