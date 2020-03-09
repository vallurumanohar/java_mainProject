package feb20;
import java.io.BufferedReader;
import java.io.FileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class UsingNotepad {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	FileReader fr;
	BufferedReader br;
@BeforeTest
public void setUp()
{
	//generate path of html report
	report=new ExtentReports("./Reports/Logindata.html");
	driver=new ChromeDriver();
}
@Test
public void verifyLogin()throws Throwable
{
fr=new FileReader("D://logindata.txt");
br=new BufferedReader(fr);
String str="";
while((str=br.readLine())!=null)
{
	test=report.startTest("Login Test");
	test.assignAuthor("Ranga");
	test.assignCategory("Using notepad");
	//split notepad data into array variable
String login[]=str.split(";");
driver.get("http://orangehrm.qedgetech.com/");
driver.manage().window().maximize();
driver.findElement(By.name("txtUsername")).sendKeys(login[0]);
driver.findElement(By.name("txtPassword")).sendKeys(login[1]);
driver.findElement(By.name("Submit")).click();
Thread.sleep(2000);
if(driver.getCurrentUrl().contains("dash"))
{
	test.log(LogStatus.PASS, "Login success");
	Reporter.log("Login success",true);
}
else
{
//get error message
String message=driver.findElement(By.id("spanMessage")).getText();
test.log(LogStatus.FAIL, message);
Reporter.log(message,true);	
}
report.endTest(test);
report.flush();
}
br.close();
}
@AfterTest
public void tearDown()
{
	driver.close();
}
}
















