import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

public class MyJSONReader {
    public static void main(String[] args) throws Exception{
        Object o = new JSONParser().parse(new FileReader("JSONExample.json"));
        JSONObject jsonObject = (JSONObject)o;

        String firstName = (String)jsonObject.get("firstName");
        String lastName = (String)jsonObject.get("lastName");

        System.out.println(firstName);
        System.out.println(lastName);

        long age = (long)jsonObject.get("age");
        System.out.println(age);

        Map address = (Map)jsonObject.get("address");
        Iterator<Map.Entry> iterator = address.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry pair =iterator.next();
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
        JSONArray jsonArray = (JSONArray) jsonObject.get("phoneNumbers");
        Iterator it1 = jsonArray.iterator();
        while (it1.hasNext()){
            iterator = ((Map) it1.next()).entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry pair = iterator.next();
                System.out.println(pair.getKey() + " : " + pair.getValue());
            }
        }
    }
}
