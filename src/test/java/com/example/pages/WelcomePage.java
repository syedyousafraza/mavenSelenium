package com.example.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage {

	private WebDriver driver;

	public WelcomePage(WebDriver driver) {
		this.driver = driver;
	}

	// locators
	private By welcomePage = By.xpath("");

	// functions

	public void verifyWelcomePage() {
		String title = driver.getTitle();
		assertEquals("Welcome To Salesforce", title);
	}

}
