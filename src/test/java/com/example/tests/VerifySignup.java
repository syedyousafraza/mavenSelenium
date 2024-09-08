package com.example.tests;

import com.example.pages.SignupPage;
import com.example.pages.WelcomePage;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class VerifySignup {

	private static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		// Initialize WebDriver (e.g., ChromeDriver)
		driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/form/signup/elf-v2-login/?d=70130000000Enus");
	}

	@Test
	public void endToEndScenario() {
		// Create an instance of the Signup page and welcome page
		SignupPage signup = new SignupPage(driver);
		WelcomePage welcome = new WelcomePage(driver);

		// Interact with the signup page using the methods from Signup class
		signup.enterFirstName("Yousaf");
		signup.enterLastName("Raza");
		signup.enterEmail("yraza@example.com");
		signup.enterPhone("12345566");
		signup.enterCompanyName("SSSSYYYYYYSSSS");
		signup.selectEmployees();
		signup.checkCheckBox();
		signup.submitForm();

		// welcome.verifyWelcomePage();
		// signup.clickSignupButton();

		// Add assertions or further steps as needed
//        String expectedTitle = "Expected Title After Signup";
//        String actualTitle = driver.getTitle();
//        assertEquals(expectedTitle, actualTitle);
	}

	@AfterClass
	public static void tearDown() {
		// Close the WebDriver
		driver.quit();
	}
}
