package org.mmp;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperClass {
	protected WebDriver driver;
	public HelperClass(WebDriver driver)
	{
		this.driver=driver;
	}
	public void navigateModule(String mname)
	{
		
		driver.findElement(By.xpath("//span[normalize-space()='"+mname+"']")).click();
		
	}
	public void LauchApplication(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public String login(String uname,String pword)
	{
		
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.name("submit")).click();
		String actual = driver.findElement(By.tagName("h3")).getText();
		return actual;
	}
	
	public void NavigatetoMenu(String SubmenuName)
	{
		driver.findElement(By.xpath("//a[@href='profile.php']/span[contains(text(),'"+SubmenuName+"')]")).click();
	}

	
	public void teardown()
	 {
		 driver.close();
	 }
}