package com.technologies.transition.weakreferences;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import com.technologies.transition.memory.MyLargeObject;

public class WeakReferencesExample {

//	static Map<User, MyLargeObject> userSessionTemp = new HashMap<User, MyLargeObject>();
	static Map<User, MyLargeObject> userSessionTemp = new WeakHashMap<User, MyLargeObject>();
	
	public static void main(String[] args) throws InterruptedException {
		
		User user1 = new User("user1");
	
		addUserLoginData(user1);
		
		user1 = null;

		while (true) {
			System.out.println("app is running...");
			Thread.sleep(3000);
		}

		
	}
	
	public static void addUserLoginData(User user) {
		userSessionTemp.put(user, new MyLargeObject(4*10e6));
	}
	
}
