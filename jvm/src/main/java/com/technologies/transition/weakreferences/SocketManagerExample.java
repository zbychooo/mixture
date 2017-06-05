package com.technologies.transition.weakreferences;

import java.net.Socket;

public class SocketManagerExample {

	private SocketManager socketManager;
	
	public void openConnectionForUser(User user, Socket socket) {
		
		socketManager.setUser(socket, user);
	}
}
