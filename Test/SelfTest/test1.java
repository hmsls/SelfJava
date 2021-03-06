package SelfTest;

import java.io.File;
import java.io.FileReader;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.util.EnvUtil;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

public class test1 {
	public static void main(String[] args) {
//		String outValue = "{\"batchNo\":\"000150111703071727130530019552\",\"decisionResult\":\"0\",\"erorcd\":\"0001\",\"erortx\":\"Source must not be null\"}";
//		boolean flag = outValue.substring(outValue.lastIndexOf("erorcd")+9,outValue.lastIndexOf("erorcd")+13).equals("0000");
//		String out = outValue.substring(outValue.lastIndexOf("erorcd")+9,outValue.lastIndexOf("erorcd")+13);
//		System.out.println(flag);
//		System.out.println(out);
//		StringBuffer sb = new StringBuffer();
//		try {
//			FileReader fr = new FileReader(new File("D:\\JavaPractice\\zhoubao\\zhoubao\\闪银测试报文.txt"));
//			int len = 0;
//			char[] buf = new char[1024];
//			while((len = fr.read(buf))!=-1){
//				sb.append(new String(buf,0,len));
//			}
//			System.out.println(sb.toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
		
			readXml();
			Trans trans = null; 
			
			String ktrPath = "C:\\Users\\LISHUAI\\Desktop\\T_SY_贷款申请信息保存.ktr";
			String[] arguments = {"1","2","3"};
			try {
				KettleEnvironment.init();
				EnvUtil.environmentInit();
				TransMeta tm = new TransMeta(ktrPath);
				trans = new Trans(tm);
				
				trans.setVariable("LoaclPath", "D:/data/kettle1");
				trans.setVariable("MessageString", readXml());
				trans.setVariable("url", "http://localhost:8080/DataPlatformWebservice/services/ReceiveEngine?wsdl");
				
				trans.execute(arguments);
				trans.waitUntilFinished();
				
				if(trans.getErrors() > 0){
					throw new Exception("There are errors during transformation exception!(传输过程中发生异常)");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static String readXml(){
			StringBuffer sb = new StringBuffer();
			try {
				FileReader fr = new FileReader(new File("‪‪D:\\JavaPractice\\zhoubao\\zhoubao\\闪银测试报文.txt"));
				int len = 0;
				char[] buf = new char[1024];
				while((len = fr.read(buf))!=-1){
					sb.append(new String(buf,0,len));
				}
				System.out.println(sb.toString());
				return sb.toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
}
