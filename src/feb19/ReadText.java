package feb19;
import java.io.BufferedReader;
import java.io.FileReader;
public class ReadText {
public static void main(String[] args) throws Throwable{
		FileReader fr=new FileReader("E://11oclock.txt");
		BufferedReader br=new BufferedReader(fr);
		String str="";
		while((str=br.readLine())!=null)
		{
			System.out.println(str);
		}
		br.close();

	}

}
