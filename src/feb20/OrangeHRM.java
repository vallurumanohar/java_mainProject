package feb20;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class OrangeHRM {
String inputpath="d://LoginData.xlsx";
String outputpath="E://Results.xlsx";
	WebDriver driver;
ExtentReports report;
ExtentTest test;
Workbook wb;
Sheet ws;
Row row;
Cell cell;
FileInputStream fi;
FileOutputStream fo;
File screen;
@BeforeTest
public void setUp()
{
	//generate path of html report
report=new ExtentReports("./Reports/Login.html");
driver=new ChromeDriver();
}
@Test
public void verifyLogin()throws Throwable
{
//read paht of excel
	fi=new FileInputStream(inputpath);
	//get wb
	wb=WorkbookFactory.create(fi);
	ws=wb.getSheet("Login");
	row=ws.getRow(0);
	int rc=ws.getLastRowNum();
	int cc=row.getLastCellNum();
	Reporter.log("no of rows::"+rc+"  "+"No of columns are::"+cc,true);
for(int i=1;i<=rc;i++)
{
test=report.startTest("Verify Login");
test.assignAuthor("Ranga","Senior QA");
test.assignCategory("Data Driven");
driver.get("http://orangehrm.qedgetech.com/");
driver.manage().window().maximize();
Thread.sleep(3000);
//read username and password columns from login sheet
String username=ws.getRow(i).getCell(0).getStringCellValue();
String password=ws.getRow(i).getCell(1).getStringCellValue();
driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(username);
driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(password);
driver.findElement(By.xpath("//input[@name='Submit']")).click();
Thread.sleep(4000);
if(driver.getCurrentUrl().contains("dash"))
{
screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screen, new File("D:\\December_Selenium\\Selenium_Framework11oclock\\Screens\\"
	+ "Iteration\\"+i+"Loginpage.png"));
test.log(LogStatus.PASS, "Login Success");	
Reporter.log("Login Success",true);
//write as login success in results column
ws.getRow(i).createCell(2).setCellValue("Login Success");
//write as Pass in Status column
ws.getRow(i).createCell(3).setCellValue("Pass");
}
else
{
screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screen, new File("D:\\December_Selenium\\Selenium_Framework11oclock\\Screens\\"
+ "Iteration\\"+i+"Loginpage.png"));
//get error message
String message=driver.findElement(By.id("spanMessage")).getText();	
Reporter.log(message,true);	
test.log(LogStatus.FAIL, message);
//write as error message in results column
ws.getRow(i).createCell(2).setCellValue(message);
//write as Fail in Status column
ws.getRow(i).createCell(3).setCellValue("Fail");
}
report.endTest(test);
report.flush();
}
fi.close();
fo=new FileOutputStream(outputpath);
wb.write(fo);
fo.close();
wb.close();
}
@AfterTest
public void tearDown()
{
	driver.close();
}
}

















