package com.java.main.utility;

public class RandomId {
	
	static RandomId randomId;
	
	static {
		randomId = new RandomId();
	}
	
	public static RandomId getInstanceId() {
		return randomId;
	}
	
	public int getRandomId(){
		
 		double random = Math.random() * 1000000; 
 		return (int) random;
 	}

}
