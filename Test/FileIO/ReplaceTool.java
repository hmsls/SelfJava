package FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javassist.tools.framedump;

public class ReplaceTool {
	public static void main(String[] args) {
		ReplaceTool rt = new ReplaceTool();
		rt.replaceTool();
	}
	public void replaceTool(){
		FileReader fr = null;
		FileWriter fw = null;
		File file = new File("D:\\JavaPractice\\zhoubao\\zhoubao\\a.txt");
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("替换前：");
//		String before = scanner.nextLine();
//		System.out.println("替换后：");
//		String after = scanner.nextLine();
		String before = "1";
		String after = "2";
		
		try {
			fr = new FileReader(new File("D:\\JavaPractice\\zhoubao\\zhoubao\\a.txt"));
			fw = new FileWriter(new File("D:\\JavaPractice\\zhoubao\\zhoubao\\a.txt"));
			
			StringBuffer sb = new StringBuffer();
			int flag = 0;
			char[] buf = new char[1024];
			while((flag = fr.read(buf))!=-1){
				sb.append(buf,0,flag);
				System.out.println(sb.toString());
			}
			String context = sb.toString().replace(before, after);
			fw.write(context);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fw != null){
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
