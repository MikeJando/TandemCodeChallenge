import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class JSONReader
{
    public static void main(String[] args)
    {
        Scanner kbd = new Scanner(System.in);

        Path inPath = Paths.get("src", "main", "resources", "Apprentice_TandemFor400_Data.json").toAbsolutePath();
        JSONParser parser = new JSONParser();
        HashMap<Integer, HashMap<String,String>> map = new HashMap<>();

        try
        {
            Reader reader = Files.newBufferedReader(inPath);
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
                    s = list.get(0)+","+list.get(1)+","+list.get(2);
                else
                    s = list.get(0)+","+list.get(1);
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

        ArrayList<Integer> asked = new ArrayList<>();

        for(int i = 0;i<10;i++)
        {
            int num = (int) (Math.random()*map.size());
            if(!asked.contains(num))
                asked.add(num);
            else
                i--;
        }

        int score = 0;

        for(int i = 0;i<asked.size();i++)
        {
            ArrayList<String> sList = new ArrayList<>();
            String[] sArr = (map.get(asked.get(i)).get("incorrect")).split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            String question = map.get(asked.get(i)).get("question");
            Collections.addAll(sList,sArr);
            sList.add(map.get(asked.get(i)).get("correct"));

            Collections.shuffle(sList);

            System.out.println(question);
            System.out.println();
            for(int j = 0;j<sList.size();j++)
            {
                System.out.println(j+" "+sList.get(j));
            }
            int answer = kbd.nextInt();

            if(sList.get(answer)==map.get(asked.get(i)).get("correct"))
                score++;

            System.out.println();
            System.out.println("The correct answer was: "+map.get(asked.get(i)).get("correct"));
            System.out.println();


        }

        if(score>=5)
            System.out.println("Great Job!  You're score was: " + score);
        else
            System.out.println("These were some tough ones!  You're score was: " + score);
    }
}