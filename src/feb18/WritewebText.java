package feb18;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class WritewebText {

	public static void main(String[] args)throws Throwable {
		File fi=new File("E://selenium.txt");
		FileWriter fw=new FileWriter(fi);
		BufferedWriter bw=new BufferedWriter(fw);
		WebDriver driver=new ChromeDriver();
		driver.get("http://primusbank.qedgetech.com/");
		driver.manage().window().maximize();
		//get para text
	String para1=driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]/p[1]")).getText();
	String para2=driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]/p[2]")).getText();
	bw.write(para1);
	bw.newLine();
	bw.newLine();
	bw.write(para2);
	bw.flush();
	bw.close();
driver.close();
	}

}

















