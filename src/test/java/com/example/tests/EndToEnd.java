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
            driver.get("https://www.saucedemo.com/");
            String pageTitle = driver.getTitle();
            System.out.println("This is my page title: " + pageTitle);
            assertEquals("Swag Labs", pageTitle);

            WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login_logo")));
            assertTrue(logo.isDisplayed());

            // Step 2: Login Test
            System.out.println("This is test to login ");

            WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
            userNameField.clear();
            userNameField.sendKeys("standard_user");
            wait.until(ExpectedConditions.attributeToBe(userNameField, "value", "standard_user"));

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            passwordField.clear();
            passwordField.sendKeys("secret_sauce");
            wait.until(ExpectedConditions.attributeToBe(passwordField, "value", "secret_sauce"));

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            loginButton.click();

            wait.until(ExpectedConditions.urlContains("/inventory.html"));

            WebElement inventoryContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
            assertTrue("Login failed: Inventory page not loaded", inventoryContainer.isDisplayed());

            System.out.println("Login successful: Inventory page loaded");

            // Step 3: Additional test (replace with actual test logic)
            System.out.println("This is also tested");

            // Add more steps as needed for your end-to-end scenario

        } catch (Exception e) {
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