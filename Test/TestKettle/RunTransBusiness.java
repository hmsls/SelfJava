package TestKettle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.util.EnvUtil;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

public class RunTransBusiness {
	public static void main(String[] args) {
		readXml();
		Trans trans = null;

		String ktrPath = "C:\\Users\\LISHUAI\\Desktop\\lishuai\\测试用\\T_SY_贷款申请信息保存.ktr";
		String[] arguments = {};
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

			if (trans.getErrors() > 0) {
				throw new Exception("There are errors during transformationexception!(传输过程中发生异常)");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public static String readXml() {

		StringBuffer sb = new StringBuffer();
		FileReader fr;
		try {
			fr = new FileReader(new File("D:\\JavaPractice\\zhoubao\\zhoubao\\test.xml"));
			int flag = 0;
			char[] buf = new char[1024];
			while ((flag = fr.read(buf)) != -1) {
				sb.append(buf, 0, flag);
//				System.out.println(sb.toString());
				// System.out.println(new String(buf,0,flag));
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
