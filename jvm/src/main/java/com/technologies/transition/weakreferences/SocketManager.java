package com.technologies.transition.weakreferences;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class SocketManager {
	private Map<Socket, User> m = new HashMap<Socket, User>();

	public void setUser(Socket s, User u) {
		m.put(s, u);
	}

	public User getUser(Socket s) {
		return m.get(s);
	}

	public void removeUser(Socket s) {
		m.remove(s);
	}
}
