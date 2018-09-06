package TestKettle;

import java.io.File;
import java.io.FileReader;

public class Test {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		FileReader fr;
		try {
			fr = new FileReader(new File("D:\\JavaPractice\\zhoubao\\zhoubao\\test.xml"));
			int flag = 0;
			char[] buf = new char[1024];
			while ((flag = fr.read(buf)) != -1) {
				sb.append(buf, 0, flag);
//				System.out.println(sb.toString());
				System.out.println(new String(buf,0,flag));
			}
//			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
