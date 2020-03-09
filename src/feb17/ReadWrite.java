package feb17;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadWrite {
public static void main(String[] args)throws Throwable {
		//get path of excel
		FileInputStream fi=new FileInputStream("E://Dummy.xlsx");
		//get wb from file
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		//get sheet from wb
		XSSFSheet ws=wb.getSheet("Login");
		//count no of rows in sheet
		int rc=ws.getLastRowNum();
		System.out.println("no of rows are::"+rc);
		for(int i=1;i<=rc;i++)
		{
			String username=ws.getRow(i).getCell(0).getStringCellValue();
			String password=ws.getRow(i).getCell(1).getStringCellValue();
			System.out.println(username+"  "+password);
			//write some text into results column
		ws.getRow(i).createCell(2).setCellValue("Iam so lazy");
		
		}
fi.close();
FileOutputStream fo=new FileOutputStream("D://Results.xlsx");
wb.write(fo);
fo.close();
wb.close();

	}
}














