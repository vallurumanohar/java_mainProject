package feb17;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadData {
public static void main(String[] args)throws Throwable {
//read path of excel file
FileInputStream fi=new FileInputStream("E://Dummy.xlsx");
//get wb from file
XSSFWorkbook wb=new XSSFWorkbook(fi);
//get sheet from wb
XSSFSheet ws=wb.getSheet("Login");
//get first row from sheet
XSSFRow row=ws.getRow(0);
//count no of rows in sheet
int rc=ws.getLastRowNum();
//count no of columns in first row
int cc=row.getLastCellNum();
System.out.println("no of rows are::"+rc+"   "+"no of columns in first row::"+cc);
//print first column and second row data in a Login sheet
String username=ws.getRow(1).getCell(0).getStringCellValue();
//print second column and second row data in a Login sheet
String password=ws.getRow(1).getCell(1).getStringCellValue();
System.out.println(username+"    "+password);
fi.close();
wb.close();


	}

}














