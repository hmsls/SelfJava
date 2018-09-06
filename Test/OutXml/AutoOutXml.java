package OutXml;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class AutoOutXml {
	public static void writeXml(){
		DocumentFactory df = DocumentFactory.getInstance();
		Document doc = df.createDocument();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] bys = new byte[1024];
		ByteArrayInputStream bis = new ByteArrayInputStream(bys);
		String newStr = null;
		
		Element Application = doc.addElement("Application");
		Element SourceCode = Application.addElement("SourceCode");
		Element Ind_Info = Application.addElement("Ind_Info");
		String[] Ind_InfoFields = {"batchNo","applyNo","custTyp"
				,"mercna","merccd","apsvtp","proType","name",
				"certifiType","certifiId","ckcifg","riskEle",
				"odueLoanCntCorp","odueLoanCntCorpOth","avlLoanCntCorp",
				"avlLoanCntOth","riskCorp","riskCorpOth"};
		for(int i = 0;i<Ind_InfoFields.length;i++){
			Element e1 = Ind_Info.addElement(Ind_InfoFields[i]);
			e1.setText("1");
		}
		
		Element PbocReport = Application.addElement("PbocReport");
		
		//创建一个优雅的格式化的输出形式。
		OutputFormat of = OutputFormat.createPrettyPrint();
		try {
			XMLWriter writer = new XMLWriter(bos,of);
			of.setEncoding("utf-8");
			writer.write(doc);
			
			int len = 0;
			while((len=bis.read(bos.toByteArray()))!=-1){
				bis.read(bos.toByteArray(), 0, bos.toByteArray().length);
				newStr = new String(bos.toByteArray(), 0, bos.toByteArray().length);
			}
			System.out.println(newStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		writeXml();
	}
}
