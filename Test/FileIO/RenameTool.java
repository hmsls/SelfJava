package FileIO;

import java.io.File;

public class RenameTool {
	public static void main(String[] args) {
		File f = new File("F:\\学习\\Python\\视频");
		File[] files = f.listFiles();
		for(File file:files){
			String name = file.getName();
			if(name.endsWith(".avi")){
				String newName = name.substring(name.lastIndexOf("_")+1,name.length());
				file.renameTo(new File(file.getParent()+File.separator+newName));
			}
		}
	}
}
