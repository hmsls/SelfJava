package TestKettle;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.util.EnvUtil;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

public class TextXmlAnalysis {
	public static void main(String[] args) {
		String[] arguments = {};
		String fpath = "C:\\Users\\LISHUAI\\Desktop\\lishuai\\测试用\\xmlAnay1.ktr";
		try {
			KettleEnvironment.init();
			EnvUtil.environmentInit();
			
			TransMeta tm = new TransMeta(fpath);
			Trans trans = new Trans(tm);
			
			trans.setVariable("XmlMessage", readXml());
			
			trans.execute(arguments);
			trans.waitUntilFinished();
			
			if(trans.getErrors()>0){
				throw new Exception("There are errors during transformationexception!(传输过程中发生异常)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String readXml(){
		StringBuffer sb = new StringBuffer();
		try {
			FileReader fr = new FileReader(new File("C:\\Users\\LISHUAI\\Desktop\\lishuai\\测试用\\xmlAnay.xml"));
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
	
	public static void  readRepeat(){
		
		try {
			Document doc = DocumentHelper.parseText(readXml());
			Element rootElement = doc.getRootElement();
			Element dataElement = rootElement.element("data");
			List<Element> testElements = dataElement.elements("test");
			for(Element el:testElements){
				String test2 = el.elementText("test2");
				String test3 = el.elementText("test3");
				System.out.println(test2+test3);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
