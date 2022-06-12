package PackRostom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import PageObjet.HomePage;
import PageObjet.PageForget;
public class Testtest1 extends Testsetup {
	/* premiere methode d'optimisation des tests
	@Test(dataProvider = "getdata")
	public void Test (String mail , String  mdp) {
		driver.findElement(By.id("email")).sendKeys("mail");
		driver.findElement(By.name("pass")).sendKeys("mdp");
		driver.findElement(By.xpath("//button[@name='login']")).click();
	}

	@DataProvider
	public Object [][]  getdata(){
		Object [][] data = new Object [3][2];
		data [0][0]= "user1";
		data [0][1]= "123";
		data [1][0]="user2";
		data [1][1]="12345";
		data [2][0]= "user3";
		data [2][1]= "654321";
		return data ;
		}*/
	// deuxieme methode lire des donneer d'un fichier excel 
	DataFormatter formatter = new DataFormatter();

	@Test(dataProvider = "getdata")
	public void Test (String mail , String  mdp, String phone)throws IOException {
		test.log(LogStatus.INFO, "je suis sur le page connexion facebook");
		HomePage HP = new HomePage(driver);
		PageForget PF = new PageForget (driver);
		HP.mailId().sendKeys(mail);
		HP.mdpId().sendKeys(mdp);
		HP.LinkForgId().click();
		PF.phoneId().sendKeys(phone);
		
		test.log(LogStatus.PASS,test.addScreenCapture(CaputureScreen (driver)) + " on a clik sur page forget et saisie le numero portble");

	}

	@DataProvider(name = "getdata")
	public Object[][] getData() throws IOException {
	FileInputStream fis = new FileInputStream("C:\\Users\\rosto\\Desktop\\Selenuim\\testrostom.xlsx");
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheet = wb.getSheetAt(0);
	int rowCount = sheet.getPhysicalNumberOfRows();
	XSSFRow row = sheet.getRow(0);
	int colCount = row.getLastCellNum();
	//System.out.println(rowCount+"    "+colCount);
	Object data[][] = new Object[rowCount][colCount];
	for (int i = 0; i < rowCount; i++) {
	row = sheet.getRow(i);
	for (int j = 0; j < colCount; j++) {
	XSSFCell cell = row.getCell(j);

	data[i][j] = formatter.formatCellValue(cell);

	}
	}
	return data;
	}
	
	public static String CaputureScreen (WebDriver driver) throws IOException {
		File ScrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File DestinationFile = new File ("C:\\Users\\rosto\\Desktop\\Selenuim\\MavenRostom\\images\\"+System.currentTimeMillis()+".png");
		
		String Absolutepath_screen= DestinationFile.getAbsolutePath();
		FileUtils.copyFile(ScrFile, DestinationFile);
		return Absolutepath_screen;
	}
}
