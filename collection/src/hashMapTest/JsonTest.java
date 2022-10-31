package hashMapTest;

import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonTest {
	public static void main(String[] args) {
		HashMap<String, Object> userMap = new HashMap<String, Object>();
		JSONObject userJSON = null;
		JSONArray users = new JSONArray();
		
		userMap.put("id", "abcde1221");
		userMap.put("pw",  "1234");
		userMap.put("name", "홍준성");
		userMap.put("age", 20);
		
		userJSON = new JSONObject(userMap);
//		System.out.println(userJSON.toJSONString());
		
		users.add(userJSON);
		
		userMap.put("id", "ae1221");
		userMap.put("pw",  "134");
		userMap.put("name", "홍성");
		userMap.put("age", 25);
		userJSON = new JSONObject(userMap);
		users.add(userJSON);
		
		System.out.println(users.toJSONString());
		
		System.out.println(((JSONObject)users.get(1)).toJSONString());
	}
}
