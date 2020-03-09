package feb17;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ReadNumericdata {
	public static void main(String[] args)throws Throwable {
		FileInputStream fi=new FileInputStream("E://Dummy.xlsx");
		Workbook wb=WorkbookFactory.create(fi);
		Sheet ws=wb.getSheet("Login");
		Row row=ws.getRow(0);
		int rc=ws.getLastRowNum();
		int cc=row.getLastCellNum();
		System.out.println(rc+"   "+cc);
	for(int i=1;i<=rc;i++)
	{
	String username=ws.getRow(i).getCell(0).getStringCellValue();
if(wb.getSheet("Login").getRow(i).getCell(1).getCellType()==Cell.CELL_TYPE_NUMERIC)
{
	//get numeric cell data
int celldata=(int)wb.getSheet("Login").getRow(i).getCell(1).getNumericCellValue();
//convert celldata cell into string type
String password=String.valueOf(celldata);
System.out.println(username+"   "+password);
//write some text into results column
ws.getRow(i).createCell(2).setCellValue("i will not practise");
}
}
fi.close();
FileOutputStream fo=new FileOutputStream("E://Dummy.xlsx");
wb.write(fo);
fo.close();
wb.close();
	}

}












