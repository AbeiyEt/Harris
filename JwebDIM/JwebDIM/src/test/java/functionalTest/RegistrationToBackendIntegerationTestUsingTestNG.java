package functionalTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
@Listeners(testNG.Listner.class)

public class RegistrationToBackendIntegerationTestUsingTestNG {
	WebDriver driver;
	Connection con;
	java.sql.Statement stmt;
  @Test
  public void chekcRegistrationPageIsWorkingWithBackend() throws SQLException {
	  driver.findElement(By.name("customerID")).sendKeys("81097");
		driver.findElement(By.name("customerName")).sendKeys("solomon");
		driver.findElement(By.name("address")).sendKeys("Coppermine RD");
		driver.findElement(By.name("city")).sendKeys("herndon");


		String submitXpath="/html/body/form[1]/table/tbody/tr[9]/td[2]/input";
		driver.findElement(By.xpath(submitXpath)).click();
		stmt= con.createStatement(); 
		ResultSet result = stmt.executeQuery("select * from customers where customerID=81097");
		while(result.next()){
			int id= result.getInt(1);
		Assert.assertEquals(id, 81097);
		}
		stmt.execute("delete from customers where customerID=81097");
		
  }
  @BeforeClass
  public void beforeClass() throws ClassNotFoundException, SQLException {
		// This code is to check whether registration page is working or not with the backedn database
		System.setProperty("webdriver.chrome.driver", utility.PathList.chromeDriver);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	// wait will be applied for any element not available for the first try
		driver.get("http://localhost/test/register.html"); // opening a website
		Class.forName("com.mysql.jdbc.Driver");  
		// create a jdbc object and connect to the database
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","");  
		// using the connector run select query and get the result
		stmt= con.createStatement(); 
	
  }

  @AfterClass
  public void afterClass() throws SQLException {

		con.close();
		driver.quit();
  }

}
