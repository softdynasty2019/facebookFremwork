package MyFramwork.Facebook;

import java.io.IOException;

import org.testng.annotations.Test;

import resources.landingPage;

public class FbSignInTest extends BaseClass{
	
	@Test
	public void basePageNavigation() throws IOException {
		
		
		
		initilizeDriver(); 
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		//Create a object to connect with Landingpage
		landingPage la=new landingPage(driver);
		la.getemail().sendKeys("softdynasty2019@gmail.com");
		la.getepass().sendKeys("12345699");
		la.Login().click();
		
				
	}
	
	
	
	
	
	

}
