package com.home.base;

public class TestUtilities extends BaseTest {

	// STATIC SLEEP 
	public static void sleep(long millis) {
		try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}