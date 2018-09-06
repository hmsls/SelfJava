package com.xxx.zhoubao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * 这个方法是测试两个文件中有哪些内容不同
 * 必须是单独的一行一行的内容
 * @author LISHUAI
 *
 */

public class Check {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream(new File("F:\\CDH大数据\\新建CDH\\导表\\result4.txt"),true);
		//这个是src文件，是内容比较多的文件
		FileReader fr = new FileReader("F:\\CDH大数据\\新建CDH\\导表\\odm_name_all.txt");
		//这个是des文件，是内容比较少的文件
		FileReader fr1 = new FileReader("F:\\CDH大数据\\新建CDH\\导表\\odm_name_last.txt");
		BufferedReader br = new BufferedReader(fr);
		BufferedReader br1 = new BufferedReader(fr1);
		List src = new ArrayList();
		List des = new ArrayList();
		
		String line = br.readLine();
		String line1 = br1.readLine();
		int count =0;
		while(line!=null){
			src.add(line);
			line = br.readLine();
			count++;
			
		}
		System.out.println("src:"+count);
		int count1 = 0;
		while(line1!=null){
			des.add(line1);
			line1 = br1.readLine();
			count1++;
		}
		System.out.println("des:"+count1);
		Iterator it =  src.iterator();
		while(it.hasNext()){
			String lines = (String)it.next();
			if(des.contains(lines)){
				System.out.println(lines+"--"+"有");
			}else{
				System.out.println(lines+"--"+"没有");
				fos.write((lines+"\n\r").getBytes());
			}
		}
		fos.close();
		System.out.println("----------------------");
		Iterator it1 = des.iterator();
		while(it1.hasNext()){
			String lines = (String)it1.next();
			if(src.contains(lines)){
//				System.out.println(lines+"--"+"有");
			}else{
//				System.out.println(lines+"--"+"没有");
			}
		}
	}
}
