package feb19;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class UsingExtentReports {
ExtentReports report;
ExtentTest test;
	@BeforeTest
	public void generatereport()
	{
	report=new ExtentReports("./Reports/Sample.html");	
	}
	@Test
	public void passTest()
	{
	test=report.startTest("Pass Test Case");
	test.assignAuthor("Ranga","Seneior QA");
	test.log(LogStatus.PASS, "test case pass");
	Assert.assertFalse(true);
	}
	@Test
	public void failTest()
	{
	test=report.startTest("Fail Test Case");
	test.assignAuthor("Ranga","Seneior QA");
	test.log(LogStatus.FAIL, "Test Case Fail");
	Assert.assertTrue(false);
	}
	@Test
	public void skipTest() {
	test=report.startTest("Skip Test Case")	;
	test.assignAuthor("Ranga","Seneior QA");
	test.log(LogStatus.SKIP, "Skipping test case");
	throw new SkipException("Test case Skiping");
	}
	@AfterMethod
	public void endreport()
	{
		report.endTest(test);
		report.flush();
	}
	
}

















