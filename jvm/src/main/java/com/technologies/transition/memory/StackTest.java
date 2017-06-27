package com.technologies.transition.memory;

public class StackTest {

	public static void main(String[] args) {
		Stack<MyLargeObject> s = new Stack<>(10000);
		for (int i = 0; i < 100; i++) {
			s.push(new MyLargeObject(10e4));
		}

		while (!s.isEmpty()) {
			s.pop();
		}

		while (true) {
			// do something
		}

	}

}