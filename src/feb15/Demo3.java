package feb15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo3 {
WebDriver driver;

@BeforeTest
public void setUp() throws Throwable
{
driver=new ChromeDriver();
	driver.get("http://primusbank.qedgetech.com/");
	driver.manage().window().maximize();
	Thread.sleep(5000);
	driver.findElement(By.name("txtuId")).sendKeys("Admin");
	driver.findElement(By.name("txtPword")).sendKeys("Admin");
	driver.findElement(By.name("login")).click();
	Reporter.log("Running beforetest",true);
}
@Test(description="Verify Branches",priority=0,enabled=true)
public void branches()throws Throwable
{
	
	driver.findElement(By.xpath("//tr//tr//tr//tr//tr[2]//td[1]//a[1]//img[1]")).click();
	Thread.sleep(5000);
	Reporter.log("Executing branches test",true);
	
}
@Test(description="Verify Roles",priority=1,enabled=false)
public void roles()throws Throwable
{
	driver.findElement(By.xpath("//tr//tr//tr[4]//td[1]//a[1]//img[1]")).click();
	Thread.sleep(5000);
	Reporter.log("Executing roles test",true);
}
@Test(description="Verify Users",priority=2,enabled=true)
public void users()throws Throwable
{
	driver.findElement(By.xpath("//tr[6]//td[1]//a[1]//img[1]")).click();
	Thread.sleep(5000);
	Reporter.log("Executing users test",true);
	
}
@AfterTest
public void tearDown() throws Throwable
{
	Thread.sleep(5000);
	Reporter.log(" Runnning AfterTest",true);
	driver.close();
}
}




















