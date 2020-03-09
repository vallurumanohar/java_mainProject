package feb21;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PropertyFile {
WebDriver driver;
Properties p;
FileInputStream fi;
@Test
public void login()throws Throwable
{
	p=new Properties();
	fi=new FileInputStream("D:\\December_Selenium\\Selenium_Framework11oclock\\OR.properties");
	p.load(fi);
	driver=new ChromeDriver();
driver.get(p.getProperty("url"));	
driver.manage().window().maximize();
driver.findElement(By.xpath(p.getProperty("Objuser"))).sendKeys("Admin");
driver.findElement(By.xpath(p.getProperty("Objpass"))).sendKeys("Admin");
driver.findElement(By.xpath(p.getProperty("Objlogin"))).click();
driver.close();
}
}















