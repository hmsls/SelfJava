package FileIO;

import java.io.File;

public class FilesList {
	public static void main(String[] args) {
		fileList();
	}
	
	public static void fileList(){
		File f = new File("C:\\Users\\LISHUAI\\Desktop\\测试上ReceiveEngine代码");
		list(f);
	}
	
	public static void list(File file){
		File[] files = file.listFiles();
		for(File ff:files){
			if(ff.isDirectory()){
				list(ff);
			}else{
				String fileName = ff.getName();
				long fileLength = ff.length();
				//返回父路径
				String parentName = ff.getParent();
				//返回文件的绝对路径，包括了自己的文件名
				String absolutePathName = ff.getAbsolutePath();
				//返回绝对的文件名，只有文件名和扩展名，没有父路径。
				String absoluteFileName = ff.getAbsoluteFile().getName();
				System.out.println(parentName+"----"+fileName+"----"+fileLength);
			}
		}
	}
}
