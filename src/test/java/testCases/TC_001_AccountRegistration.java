package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountRegPage;
import PageObjects.HomePage;

public class TC_001_AccountRegistration extends BaseClass
{

	@Test(groups= {"Regression", "Master"})
	public void test_Account_Reg() throws InterruptedException
	{
		try
		{
		HomePage hp= new HomePage(driver);
		hp.clickReg();
		AccountRegPage ar= new AccountRegPage(driver);
		ar.inputfirstname("Rasheed");
		ar.inputlastname("Khan");
		ar.inputemail(randomString()+"@gmail.com");
		ar.inputpwd("password123");
		ar.inputconfpwd("password123");
		ar.inputreg();
		String confirmsg=ar.msgconfirmation();
		Assert.assertEquals(confirmsg, "Your registration completed");
		}catch(Exception e)
		{
			Assert.fail();
		}
	}
}
