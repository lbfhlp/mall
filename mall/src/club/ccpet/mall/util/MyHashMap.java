package club.ccpet.mall.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

public class MyHashMap{
	public static void main(String[] args) {
		Map<String, String> map=new HashMap<String, String>();
		int i=0;
		while(i<3) {
			map.put(new String("1"),new String(""+i));
			i++;
		}
		for(String temp:map.keySet()) {
			System.out.println(map.get(temp));
		}
	}
}
