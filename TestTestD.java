package PackRostom;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import PageObjet.HomePage;
public class TestTestD extends Testsetup {
	@Test
	public void TestE() throws IOException  {
				test.log(LogStatus.INFO,"Je suis sur la page login facebook");
		HomePage HP = new HomePage(driver);
		HP.mailId().sendKeys("mail");// remplce driver.findElement(By.id("email")).sendKeys("mail");
				test.log(LogStatus.WARNING, "utilisateur est entrain de siasie son email");
		HP.mdpId().sendKeys("mdp123"); //remplace driver.findElement(By.id("pass")).sendKeys("mdp");
		String tittle = driver.getTitle();
		System.out.println(tittle);
				test.log(LogStatus.PASS,"login et mdp sont incorrect le titre de la pge est: "+tittle);
	}
}
