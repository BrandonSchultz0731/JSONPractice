import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName","Brandon");
        jsonObject.put("lastName","Schultz");
        jsonObject.put("age",21);

        Map map = new LinkedHashMap(4);
        map.put("streetAddress","123 Main Street");
        map.put("city","My City");
        map.put("state","FL");
        map.put("postalCode",33433);
        jsonObject.put("address",map);

        JSONArray jsonArray = new JSONArray();
        map = new LinkedHashMap(2);
        map.put("type","home");
        map.put("number","123 456-7890");
        jsonArray.add(map);

        map = new LinkedHashMap(2);
        map.put("type","work");
        map.put("number","123 555-1234");
        jsonArray.add(map);
        jsonObject.put("phoneNumbers",jsonArray);
        PrintWriter pw = new PrintWriter("JSONExample.json");
        pw.write(jsonObject.toJSONString());

        pw.flush();
        pw.close();
    }
}
