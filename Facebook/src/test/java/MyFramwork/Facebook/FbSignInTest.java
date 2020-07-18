package MyFramwork.Facebook;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import resources.landingPage;

public class FbSignInTest extends BaseClass{
	
	@Test
	public void basePageNavigation() throws IOException {
		
		datadriven data=new datadriven();
		ArrayList tData=data.getData("Login7");
		
		String Username=(String) tData.get(1);
		String Password=(String) tData.get(2);
		initilizeDriver(); 
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		//Create a object to connect with Landingpage
		landingPage la=new landingPage(driver);
		la.getemail().sendKeys(Username);
		la.getepass().sendKeys(Password);
		la.Login().click();
		
				
	}
	
	
	
	
	
	

}
