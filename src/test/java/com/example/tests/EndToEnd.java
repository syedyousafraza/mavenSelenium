package com.example.tests;

import com.example.utils.DriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

public class EndToEnd {

	private static WebDriver driver;
	private static WebDriverWait wait;

	@BeforeClass
	public static void setUp() {
		driver = DriverManager.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void endToEndScenario() {
		try {
			// Step 1: Test URL and page title
			driver.get("https://www.salesforce.com/form/signup/elf-v2-login/?d=70130000000Enus");
			String pageTitle = driver.getTitle();
			System.out.println("This is my page title: " + pageTitle);
			assertEquals("Sales Cloud Free Trial - Salesforce.com", pageTitle);

			WebElement firstName = driver.findElement(By.xpath("//input[@name='UserFirstName']"));
			firstName.sendKeys("Hello");
			
			
            // Step 2: Here we are using few waits
            WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='UserLastName']")));
            lastName.sendKeys("John Doe");
            
            //Selection of country from dropdown
            
            WebElement countryName = driver.findElement(By.xpath("//select[@name='CompanyCountry']//option[@value='AU']"));
            countryName.click();
            assertTrue(countryName.isSelected());
            
            //Loop to all dropdown values

             
             for(int i=1; i<100; i++) {
            	 WebElement allCountries = driver.findElement(By.xpath("//option[text()='Country/Region']//following-sibling::option[" + i + "]"));
          // 	    WebElement countryOption = driver.findElement(By.xpath("//select[@name='CompanyCountry']//option[" + i + "]"));

            	 allCountries.click();
            	 
            	    // Optional: Verify if the option is selected or perform any other checks
            	    if (allCountries.isSelected()) {
            	        System.out.println("Option " + i + " selected: " + allCountries.getText());
            	    } else {
            	        System.out.println("Option " + i + " could not be selected.");
            	    }
            	 
             }
            
            

            
            

		}
		catch (Exception e) {
			System.out.println("Test failed: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@AfterClass
	public static void tearDown() {
		// Uncomment the next line when you want to close the browser after all tests
		DriverManager.quitDriver();
	}
}