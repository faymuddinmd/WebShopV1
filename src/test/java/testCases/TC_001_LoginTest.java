package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;

public class TC_001_LoginTest extends BaseClass
{
	@Test(groups= {"Sanity", "Master"})
	public void testLogin()
	{
		try {
		HomePage hp = new HomePage(driver);
		hp.clickLogin();
		LoginPage lp = new LoginPage(driver);
		lp.inputemail(rb.getString("email"));
		lp.inputpwd(rb.getString("pwd"));
		lp.clickLogin();
		MyAccountPage mp = new MyAccountPage(driver);
		boolean targetpage = mp.isMyAccountexist();
		Assert.assertEquals(targetpage, true);
		}catch(Exception e)
		{
			Assert.fail();
		}
		
		
	}

}
