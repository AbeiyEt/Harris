package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
	public static WebDriver driver;
	
	// this is comment 
	// additonal comment 
	// neges 
	public  Browser(String browserName){
		if(browserName=="Chrome"){
			System.setProperty("webdriver.chrome.driver", utility.PathList.chromeDriver);
			driver= new ChromeDriver();

		}else if(browserName=="Firefox"){
			System.setProperty("webdriver.gecko.driver", utility.PathList.firefoxDriver);
			driver= new FirefoxDriver();

		}else if(browserName=="IE"){
			System.setProperty("webdriver.InternetExplorer.driver", utility.PathList.internetExplorer);
			driver=new InternetExplorerDriver(); 
		} else{
			System.out.println("Chrome| Firfox| IE");
		
		}
		
	}

}
