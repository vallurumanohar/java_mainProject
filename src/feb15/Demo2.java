package feb15;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo2 {
WebDriver driver;
@BeforeMethod
public void setUp()
{
driver=new ChromeDriver();
	driver.get("http://newtours.demoaut.com/");
	driver.manage().window().maximize();
	Reporter.log("Running beforemethod",true);
}
@Test(priority=2)
public void register()throws Throwable
{
driver.findElement(By.partialLinkText("REG")).click();
Thread.sleep(4000);
Reporter.log("Executing register test",true);
}
@Test(priority=1)
public void home()throws Throwable
{
driver.findElement(By.partialLinkText("Hom")).click();
Thread.sleep(4000);
Reporter.log("Executing home test",true);
}
@Test(priority=0)
public void Vacation()throws Throwable
{
driver.findElement(By.partialLinkText("Vac")).click();
Thread.sleep(4000);
Reporter.log("Executing Vacation test",true);
}
@AfterMethod
public void tearDown() throws Throwable
{
Reporter.log("Running AfterMethod",true);
Thread.sleep(4000);
	driver.close();
}
}















