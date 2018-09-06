package TestKettle;

import java.io.File;
import java.io.FileReader;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.util.EnvUtil;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

public class TestStructure {
	
	public static void main(String[] args) {
		String fname = "C:\\Users\\LISHUAI\\Desktop\\lishuai\\自己测试用\\XMZD\\两个转换连接\\case条件测试.ktr";
		String[] arguments = {};
		try {
			KettleEnvironment.init();
			EnvUtil.environmentInit();
			
			TransMeta tm = new TransMeta(fname);
			Trans trans = new Trans(tm);
			
			trans.setVariable("LoaclPath", "D:\\data\\kettle\\0013\\20160307\\0008\\0000\\20160307000800000061\\");
			trans.setVariable("Batchno", "cs123456789");
			trans.setVariable("url", "http://localhost:8080/DataPlatformWebservice/services/ReceiveEngine?wsdl");
			trans.setVariable("MessageString", readXml());
			trans.setVariable("pbocFlag", "1");
			
			trans.execute(arguments);
			trans.waitUntilFinished();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String readXml(){
		StringBuffer sb = new StringBuffer();
		FileReader fr = null;
		
		try {
			fr = new FileReader(new File("D:\\data\\kettle\\0013\\20160307\\0008\\0000\\20160307000800000061\\res\\res_xmzdyw.xml"));
			int len = 0;
			char[] buf = new char[1024];
			while((len = fr.read(buf))!=-1){
				sb.append(new String(buf,0,len));
			}
			
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
