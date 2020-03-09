package feb18;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
public class WriteText {
public static void main(String[] args)throws Throwable {
		//create file
		File fi=new File("E://11oclock.txt");
		FileWriter fw=new FileWriter(fi);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write("i want job in top mnc");
		bw.newLine();
		bw.write("with out parctise and listing");
		bw.newLine();
		bw.write("with 20 lpackage");
		bw.flush();
		bw.close();

	}

}
