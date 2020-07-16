package MyFramwork.Facebook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public WebDriver driver;
	// Get Data From Properties File 

	public WebDriver initilizeDriver() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(".\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		
		// Method For Open Browser
		
						
		if (browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Basement_PC\\Desktop\\Browser Driver\\chromedriver.exe");
			 
			 driver=new ChromeDriver();
					
		}
		
		else if (browserName.equals("firefox")) {
			
			
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Basement_PC\\Desktop\\Browser Driver\\geckodriver.exe");
		    
		  driver = new FirefoxDriver();
			
		}
		
		else if (browserName.equals("IE")) {
			System.out.println("open IE");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
		
		
	}
	

	
	
	
	
	
	

	// Method 1-Edit Object by name

	public void editObjByname(String objLoc, String ObjData) {

		// Reporter.log("====Script Start=====");

		WebElement obje = driver.findElement(By.name(objLoc));
		obje.clear();
		obje.sendKeys(ObjData);
		
	}

	// Method2 -Only for Click with ID

	public void clickObjbyID(String objLoc) {

		try {
			WebElement obje = driver.findElement(By.id(objLoc));
			obje.click();

		} catch (Throwable t) {
			t.getCause();
		}
	}

	// Method -Only for Click with Name

	public void clickObjname(String objLoc) {
		try {
			WebElement obje = driver.findElement(By.name(objLoc));
			obje.click();
		} catch (Throwable t) {
			t.getCause();
		}
	}

}
