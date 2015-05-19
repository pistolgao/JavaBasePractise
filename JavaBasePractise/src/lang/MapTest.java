package lang;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String,String>();
		map.put("1", "1");
		map.put("2", "2");
		Map<String,String> map1 = new HashMap<String,String>();
		map.put("11", "11");
		map.put("22", "22");
		Map<String,Map<String,String>> maps = new HashMap<String,Map<String,String>>();
		maps.put("1", map);
		maps.put("2", map);
		
		Map fillMap = new HashMap();
		for(Entry entry: maps.entrySet()){
			fillMap.put(entry.getKey(), (Map<String,String>)entry.getValue());
		}
				
//		System.out.println(fillMap.get("2"));
		System.out.println(((Map)fillMap.get("2")).get("22"));
	}

}
