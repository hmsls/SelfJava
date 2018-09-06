package TestJson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestJson {
	private static String diskListContent = "[{\"n1\":\"asd\",\"n2\":22,\"n3\":\"45.40GB\"," + "\"n4\":\"qwerty\",\"n5\":\"asd\",}," + "{\"n1\":\"local\","
            + "\"n2\":1,\"n3\":\"279.40GB\",\"n4\":\"ST3300656SS\",\"n5\":\"\\/devm\\/d0\"}]";
	private static List<Map<String,String>> jsonStringToList(String jsContent){
		JSONArray jsArray = JSONArray.fromObject(jsContent);
		System.out.println("json字符串内容如下");
        System.out.println(jsArray);
        
        List<Map<String,String>> jsList = new ArrayList<Map<String,String>>();
        for(int i=0;i<jsArray.size();i++){
        	JSONObject jsObj = jsArray.getJSONObject(i);
        	Map<String,String> map = new HashMap<String,String>();
        	for(Iterator<?> it=jsObj.keys();it.hasNext();){
        		String key = (String)it.next();
        		String value = jsObj.get(key).toString();
        		map.put(key,value);
        	}
        	jsList.add(map);
        }
        return jsList;
	}
	
	public static void main(String[] args) {
		List<Map<String,String>> jsList = jsonStringToList(diskListContent);
		 System.out.println("json字符串成map");
		 for(Map<String,String> m:jsList){
			 System.out.println(m);
		 }
		 System.out.println("map转换成json字符串");
		 for(Map<String,String> m:jsList){
			 JSONArray jsonArray = JSONArray.fromObject(m);
			 System.out.println(jsonArray.toString());
		 }
		 System.out.println("list转换成json字符串");
		 JSONArray jsArray2 = JSONArray.fromObject(jsList);
		 System.out.println(jsArray2.toString());
	}
}
