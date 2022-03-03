package com.listparameterization;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;

public class TestUsingListParameterization {

	WebDriver driver;
	String url = "http://demo.automationtesting.in/Index.html";

	@Given("navigate to demo automation site")
	public void navigate_to_demo_automation_site() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\WindowsDrive\\Selenium_Jar\\Driver\\Runner\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@Then("enter the valid username")
	public void enter_the_valid_username(DataTable credentials) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		List<List<String>> data = credentials.cells();
		driver.findElement(By.id("email")).sendKeys(data.get(0).get(0));
	}

	@Then("click the submit button")
	public void click_the_submit_button() {
		driver.findElement(By.id("enterimg")).click();
	}

	@Then("enter the user details")
	public void enter_the_user_details(DataTable userInfo) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		List<List<String>> data = userInfo.cells();
		// enter the first name
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(data.get(0).get(0));

		// enter the last name
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(data.get(0).get(1));

		// enter the address
		driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys(data.get(0).get(2));

		// enter the email address
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(data.get(0).get(3));

		// enter the phone number
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(data.get(0).get(4));

	}

	@Then("verify submit and refresh button")
	public void verify_submit_and_refresh_button() {

		// verify the refresh and submit button

		if (driver.findElement(By.id("submitbtn")).isDisplayed()
				&& driver.findElement(By.id("Button1")).isDisplayed()) {
			System.out.println("Both the button displayed");
		} else {
			System.out.println("Button not displayed");
		}
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
	}
}
