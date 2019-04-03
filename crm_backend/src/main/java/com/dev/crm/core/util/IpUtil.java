package com.dev.crm.core.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpUtil {

	private IpUtil() {
		
	}
	
	@SuppressWarnings("unused")
	private static String getCurrentIPAddress() {
		
		try {
			InetAddress address = InetAddress.getLocalHost();
			String currentIPAddress = address.getHostAddress();
			return currentIPAddress;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unused")
	private static String getCurrentUserMachine() {
		
		try {
			InetAddress address = InetAddress.getLocalHost();
			String currentUserMachine = address.getHostName();
			return currentUserMachine;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unused")
	private static String getCurrentUserSystem() {
		
		String currentUserSystem = System.getProperty("user.name");
		return currentUserSystem;
	}
}

