package FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class tezt {
	public static void main(String[] args) throws Exception {
		StringBuffer sb = new StringBuffer();
		FileReader fr = new FileReader(new File("D:\\JavaPractice\\zhoubao\\zhoubao\\a.txt"));
		int flag = 0;
		char[] buf = new char[1024];
		while((flag = fr.read(buf))!=-1){
			sb.append(buf,0,flag);
			System.out.println(sb.toString());
//			System.out.println(new String(buf,0,flag));
		}
	}
}
