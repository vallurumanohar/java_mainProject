package feb17;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadAllRows {
public static void main(String[] args) throws Throwable {
	FileInputStream fi=new FileInputStream("E://Dummy.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(fi);
	XSSFSheet ws=wb.getSheetAt(0);
	int rc=ws.getLastRowNum();
	System.out.println("rows are::"+rc);
	for(int i=1;i<=rc;i++)
	{
	String username=ws.getRow(i).getCell(0).getStringCellValue();
	String password=ws.getRow(i).getCell(1).getStringCellValue();
	System.out.println(username+"   "+password);
		}
fi.close();
wb.close();
	}

}














