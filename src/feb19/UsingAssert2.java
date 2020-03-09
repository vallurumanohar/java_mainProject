package feb19;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class UsingAssert2 {
WebDriver driver;
@Test
public void tc1()
{
driver=new ChromeDriver();
driver.get("https://google.com");
driver.manage().window().maximize();
String Exptitle="Google";
String Acttitle=driver.getTitle();
try {
Assert.assertTrue(Acttitle.equalsIgnoreCase(Exptitle),"Title is not matching");
}catch(Throwable t)
{
System.out.println(t.getMessage());	
}
driver.quit();
}
}















