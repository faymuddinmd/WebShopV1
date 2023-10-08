package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass 
{
	public static WebDriver driver;
	public ResourceBundle rb;// load config.properties
	@BeforeClass(groups= {"Master", "Regression","Sanity"})
	public void setup()
	{
		rb = ResourceBundle.getBundle("config");// load config.properties
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appurl"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Master", "Regression","Sanity"})
	 public void tearDown()
	{
		driver.close();
	}
	
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber()
	{
		String generateNumbers = RandomStringUtils.randomNumeric(5);
		return generateNumbers;
	}
	
	public String captureScreen(String tname) throws IOException
	{
	
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\screenshots" + tname + "_"+ timeStamp + ".png";
		try {
			FileUtils.copyFile(source, new File(destination));
			} catch (Exception e) {
				e.getMessage();
			}
		return destination;
	}

}
