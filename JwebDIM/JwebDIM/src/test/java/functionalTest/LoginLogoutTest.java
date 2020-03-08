package functionalTest;

import org.testng.annotations.Test;

import objectRepository.Browser;
import objectRepository.FlightFinderPage;
import objectRepository.HomePage;
import objectRepository.MenuPage;
import objectRepository.RegistrationPage;
import objectRepository.SignOnPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class LoginLogoutTest {
	WebDriver driver;
	
	SignOnPage signOnPage;
	
	// comment 

		@BeforeClass
	public void beforeTest(){
		new Browser("IE");
		driver= Browser.driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = "http://newtours.demoaut.com/";
		driver.get(url);
	
			}
	@AfterClass 
	public void afterClass(){
		driver.close();
	}
	@AfterMethod
	public void afterTest(){
		System.out.println("running -^^^^^^^^66-------------");
	
	}
	
// login test with correct user name and password	
  @Test(dataProvider = "correctCredencials")
  public void testingWithCorrectCredencials(String u, String p) {
	// write your code over here
	 driver= signOnPage.signon(u, p);
	String title = driver.getTitle();
	Assert.assertTrue(title.contains("Mercury "));
    
  }
  
 
  // data providor for correct user name and password
  @DataProvider
  public Object[][] correctCredencials() {
    return new Object[][] {
      new Object[] { "a", "a" },
      new Object[] { "b", "b" },
    
    };
   
    
  }
  
  
//login test with Wrong user name and password	
 @Test(dataProvider = "wrongCredencials")
 public void testingWithWrongCredencials(String u, String p) throws InterruptedException {
	 driver= signOnPage.signon(u, p);
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Mercury "));
 
 }

 // data providor for correct user name and password
 @DataProvider
 public Object[][] wrongCredencials() {
	 
   return new Object[][] {
     new Object[] { "1111166", "111111" },
     new Object[] { "####", "######" },
    
   };
  
   
 }
  
  
  
  
  
}
