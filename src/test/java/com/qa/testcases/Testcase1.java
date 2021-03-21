package com.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testcase1 {
	public static WebDriver driver; 
	
	@BeforeClass
	public void openbrowserTest()  // will be called as test method
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		
	driver = new ChromeDriver();  // open chrome browser
		
	// maximise your screen
		driver.manage().window().maximize();
	
	// 	opne the url on the browser
		
		driver.get("https://www.wikipedia.org/");
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		
		String title=driver.getTitle();  // fetch title of the page
		System.out.println("the title of serach page is : "+ title);	
		
		
	}
	@Test(priority='1')
	public void SearchboxTest() throws InterruptedException
	{
	driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("seleniumAutomation");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	}
	
	@Test(priority='2')
	public void mainPageTest() throws InterruptedException
	{
		Thread.sleep(3000);
		String title=driver.getTitle();  // fetch title of the page
		System.out.println("the title of the new page is : "+ title);
		// click on main Page link
		//Thread.sleep(3000);
		driver.findElement(By.linkText("Main page")).click();
	}
	
	
	@Test(priority='3')
	public void CreateAccountPageTest() throws InterruptedException
	{
		String title=driver.getTitle();  // fetch title of the page
		System.out.println("the title of the main account page is : "+ title);
		// click on main Page link
		driver.findElement(By.linkText("Create account")).click();
		String title1=driver.getTitle();  // fetch title of the page
		System.out.println("the title of the create account page is : "+ title1);
		driver.findElement(By.xpath("//input[@id='wpName2']")).sendKeys("sonal");
		driver.findElement(By.xpath("//input[@id='wpPassword2']")).sendKeys("abc@123");
		Thread.sleep(3000);
	}
	
	@Test(priority='4')
	public void dropdownTest() throws InterruptedException
	{
		driver.navigate().to("https://ironspider.ca/forms/dropdowns.htm");
		String title1=driver.getTitle();  // fetch title of the page
		System.out.println("the title of the new page is : "+ title1);
		
		Select li= new Select(driver.findElement(By.xpath("//select[@name='coffee']")));
		
		li.selectByVisibleText("With cream & sugar");
		
		Thread.sleep(3000);
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		
		System.out.println("Close the browser");
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
