package com.utilities;

public class WebEvents {
	
public static void waitHere(int time) {
		
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
