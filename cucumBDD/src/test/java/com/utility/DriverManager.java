package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void setDriver() {
		if (driver.get() == null) {
			driver.set(new ChromeDriver()); // Initialize WebDriver -> setter
		}
	}

	public static WebDriver getDriver() {
		return driver.get(); // -> getter
	}

	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}
}
