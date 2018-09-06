package CharacterSetTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * 我的IDE本身输入的字符串是UTF-8的
 * 
 * @author LISHUAI
 *
 */
public class ChangeCharacterSetUtil {
	public static String ascii2Utf(String src) {
		byte[] u8;
		String u8Str = null;
		try {
			u8 = src.getBytes("ASCII");
			u8Str = new String(u8, "ASCII");
			return u8Str;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String utf2Asscii(String src){
		byte[] as;
		String assStr = null;
		try {
			as = src.getBytes("ASCII");
			assStr = new String(as,"ASCII");
			return assStr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return assStr;
	}

	public String getStrFromFile() {
		String str = null;
		try {
			FileInputStream fis = new FileInputStream(
					new File("D:\\JavaPractice\\zhoubao\\zhoubao\\src\\test\\java\\CharacterSetTest\\character.txt"));
			byte[] buf = new byte[1024];
			int len = 0;
			while((len = fis.read(buf))!=-1){
				fis.read(buf);
				str = new String(buf,0,len);
			}
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
}
