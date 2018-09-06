package TestKettle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.Result;
import org.pentaho.di.core.RowMetaAndData;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.util.EnvUtil;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

public class RunTransPBOC {
	public static void main(String[] args) {
//		System.out.println(readXml());
		String ktrPath = "C:\\Users\\LISHUAI\\Desktop\\lishuai\\自己测试用\\XMZD\\transform\\T_XMZD_有氧查本地人行征信报告.ktr";
		String[] arguments = {};
		try {
			KettleEnvironment.init();
			EnvUtil.environmentInit();
			
			TransMeta tm = new TransMeta(ktrPath);
			Trans trans = new Trans(tm);
			
			trans.setVariable("LoaclPath", "D:/data/pboc");
			trans.setVariable("MessageString", readXml());
			trans.setVariable("url", "http://localhost:8080/DataPlatformWebservice/services/ReceiveEngine?wsdl");
			
			trans.execute(arguments);
			trans.waitUntilFinished();
			
			Result rs = trans.getResult();
			RowMetaAndData rmad = null;
			List<RowMetaAndData> list = rs.getRows();
			Iterator it = list.iterator();
			while(it.hasNext()){
				rmad = (RowMetaAndData) it.next();
				String rrr = rmad.getString(3, null);
				System.out.println(rrr);
//				System.out.println(rmad.toString());
			}
			
			if(trans.getErrors()>0){
				throw new Exception("There are errors during transformationexception!(传输过程中发生异常)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static String readXml(){
		FileReader fr ;
		StringBuffer sb = new StringBuffer();
		try {
			fr = new FileReader(new File("G:\\WORK\\java_work\\报文\\报文\\小马助贷项目\\小马测试\\小马助贷-人行-信息测试 .xml"));
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
