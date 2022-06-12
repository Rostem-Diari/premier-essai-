package PackRostom;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Testsetup {
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;

	@BeforeMethod
	public void AvantMethode() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rosto\\Desktop\\Selenuim\\telechargment\\pilote driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		report = new ExtentReports("C:\\Users\\rosto\\Desktop\\Selenuim\\MavenRostom\\rapport\\rapport.html", false);
		test = report.startTest("Maven Rostom rapport");
		driver.get("https://fr-fr.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void Apresmethode() {
		driver.close();
		report.endTest(test);
		report.flush();
	}

}
