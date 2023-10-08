package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC_02_LoginTestDDT extends BaseClass 
{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void testLogin_DDT(String email, String pwd, String exp)
	{
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickLogin();
		LoginPage lp = new LoginPage(driver);
		lp.inputemail(email);
		lp.inputpwd(pwd);
		lp.clickLogin();
		MyAccountPage mp = new MyAccountPage(driver);
		boolean targetpage = mp.isMyAccountexist();
		if(exp.equals("Valid"))
		{
			if(targetpage==true)
			{
				mp.clickLogout();
				Assert.assertTrue(true); 
			}
			else
			{
				Assert.fail();
			}
		}
		if(exp.equals("Invalid"))
		{
			if(targetpage==true)
			{
				mp.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		}catch(Exception e)
		{
			Assert.fail();
		}
		
		
	}

}
