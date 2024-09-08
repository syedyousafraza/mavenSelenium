package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage {

	private WebDriver driver;

	// Locators
	private By firstNameField = By.name("UserFirstName");
	private By lastNameField = By.name("UserLastName");
	private By emailField = By.name("UserEmail");
	private By phoneField = By.name("UserPhone");
	private By signupButton = By.xpath("//*[@name='start my free trial']");
	private By companyName1 = By.name("CompanyName");
	private By employeeCount = By.xpath("//select[@name='CompanyEmployees']/option[@value='100']");
	private By termCheckbox = By.xpath("//div[@class='msaCheckbox checkboxInput section']/div/div/div[@class='checkbox-ui']");
	
	

	//   WebElement companyName = driver.findElement(By.xpath("//*[@id=\"CompanyName-CVgq\"]")); 

	// Constructor
	public SignupPage(WebDriver driver) {
		this.driver = driver;
	}

	// Methods to interact with the page
	
	
	public void checkCheckBox() {
		WebElement checkbox = driver.findElement(termCheckbox);
		checkbox.click();
	}
	
	public void submitForm() {
		WebElement signup = driver.findElement(signupButton);
		signup.submit();
		
	}
	
	public void selectEmployees() {
		WebElement employee = driver.findElement(employeeCount);
		employee.click();
		
	}

	public void enterFirstName(String firstName) {
		WebElement firstNameElem = driver.findElement(firstNameField);
		firstNameElem.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		WebElement lastNameElem = driver.findElement(lastNameField);
		lastNameElem.sendKeys(lastName);
	}

	public void enterEmail(String email) {
		WebElement emailElem = driver.findElement(emailField);
		emailElem.sendKeys(email);
	}

	public void enterPhone(String password) {
		WebElement passwordElem = driver.findElement(phoneField);
		passwordElem.sendKeys(password);
	}

	public void clickSignupButton() {
		WebElement signupBtn = driver.findElement(signupButton);
		signupBtn.click();
	}

	public void enterCompanyName(String name) {    	
		WebElement company = driver.findElement(companyName1);
		company.sendKeys(name);    	


	}
}
