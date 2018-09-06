package com.xxx.zhoubao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * 检查周报谁没交
 *
 */
public class ChenkZhouBao {
	
	private static ArrayList<String> names = new ArrayList<String>();
	static String[] people = {""};
	
	
	private static FileOutputStream fos = null;
		
	private static SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
	
    public static void main( String[] args ){
    	Date now = new Date();
    	String time = sdf.format(now);
    	int count = 0;
    	
    	/**
    	 * 得到每个周报中的人的名字，将名字放到集合中
    	 */
    	File file = new File("F:\\周报及其他文档整理\\20170811个人周报、项目周报、周工作简报\\个人周报");
    	try {
    		String fileName = "F:\\java_file\\other_file\\"+time+"-没交人员名单.txt";
			fos = new FileOutputStream(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	String[] filenames = file.list();
    	for(String name:filenames){
    		//注意这里取名字时，前后必须是英文状态下时的“-”,而且前后都没有空格
    		String newName =  name.substring(name.indexOf("-")+1, name.indexOf("-", name.indexOf("-")+1));
    		names.add(newName);
    	}
    	
    	System.out.println("总人数： "+people.length);
    	for(String p:people){
    		if(names.contains(p)){
    			System.out.println(p+": 交");
    		}else{
    			try {
    				count++;
					fos.write(p.getBytes());
					fos.write("，".getBytes());
				} catch (Exception e) {
					e.printStackTrace();
				}
    			System.out.println(p+": 没交");
    			
    		}
    	}
    	try {
    		fos.write("\r\n".getBytes());
    		fos.write("没交周报人数：".getBytes());
    		fos.write(String.valueOf(count).getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
