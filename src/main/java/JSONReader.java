import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class JSONReader
{
    public static HashMap<Integer, HashMap<String,String>> read(Path p)
    {

        JSONParser parser = new JSONParser();
        HashMap<Integer, HashMap<String,String>> map = new HashMap<>();

        try
        {
            Reader reader = Files.newBufferedReader(p);
            Object obj = parser.parse(reader);
            JSONArray jArr = (JSONArray) obj;

            for(int i = 0;i<jArr.size();i++)
            {
                JSONObject x = (JSONObject) jArr.get(i);
                HashMap<String, String> innerMap = new HashMap<>();

                innerMap.put("question",(String) x.get("question"));

                ArrayList<String> list = (JSONArray)x.get("incorrect");
                String s;
                if(list.size()==3)
                    s = list.get(0)+"@"+list.get(1)+"@"+list.get(2);
                else
                    s = list.get(0)+"@"+list.get(1);
                innerMap.put("incorrect",s);

                innerMap.put("correct",(String) x.get("correct"));

                map.put(i, innerMap);
            }

            reader.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        return map;
    }
}