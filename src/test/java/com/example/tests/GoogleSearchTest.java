package com.example.tests;

import com.example.utils.DriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

public class GoogleSearchTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testURL() {
        String pageTitle = driver.getTitle();
        System.out.println("This is my page title: " + pageTitle);
        assertEquals("Swag Labs", pageTitle);

        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login_logo")));
        assertTrue(logo.isDisplayed());
    }

    @Test
    public void loginTest() {
        try {
            System.out.println("This is successful test to login ");

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
            
            // Add a pause to keep the browser open
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Login test failed: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Test
    public void failedLogin() {
        System.out.println("This is failed login case");
        
        WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        userNameField.clear();
        userNameField.sendKeys("user");
        wait.until(ExpectedConditions.attributeToBe(userNameField, "value", "user"));

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordField.clear();
        passwordField.sendKeys("secret_sauce");
        wait.until(ExpectedConditions.attributeToBe(passwordField, "value", "secret_sauce"));

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        loginButton.click();
        
        
        WebElement error = driver.findElement(By.cssSelector("h3[data-test='error']")); 
        
        assertTrue("Error message is displayed",  error.isDisplayed());    
      //  assertFalse("Error message should not be displayed", error.isDisplayed());



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

    @After
    public void tearDown() {
        // Comment out the next line to keep the browser open after tests
        // DriverManager.quitDriver();
    }
}