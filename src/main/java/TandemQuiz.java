import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class TandemQuiz
{
    public static void main(String[] args)
    {
        Scanner kbd = new Scanner(System.in);
        Path inPath = Paths.get("src", "main", "resources", "Apprentice_TandemFor400_Data.json").toAbsolutePath();

        HashMap<Integer, HashMap<String, String>> map = JSONReader.read(inPath);

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
        boolean check = false;
        int answer = 0;

        for(int i = 0;i<asked.size();i++)
        {
            ArrayList<String> sList = new ArrayList<>();
            String[] sArr = (map.get(asked.get(i)).get("incorrect")).split("@");
            String question = map.get(asked.get(i)).get("question");
            Collections.addAll(sList,sArr);
            sList.add(map.get(asked.get(i)).get("correct"));

            Collections.shuffle(sList);

            System.out.println("Welcome to another game of the Tandem Quiz Challenge!");
            System.out.println();

            System.out.println(question);
            System.out.println();
            for(int j = 0;j<sList.size();j++)
            {
                System.out.println(j+" - "+sList.get(j));
            }
            System.out.println();
            System.out.println("Enter the number for your guess: ");
            while(!kbd.hasNextInt())
            {
                System.out.println("That was not a valid option, please try again: ");
                kbd.next();
            }
            answer = kbd.nextInt();
            if(answer>=sList.size())
                check = true;

            while(check)
            {
                kbd.nextLine();
                System.out.println("That was not a valid option, please try again: ");
                answer = kbd.nextInt();
                if(answer<sList.size()&& answer>-1)
                    check = false;
            }


            if(sList.get(answer)==map.get(asked.get(i)).get("correct"))
            {
                System.out.println();
                System.out.println(map.get(asked.get(i)).get("correct")+" was the correct answer!");
                System.out.println();
                score++;
            }
            else
                {
                System.out.println();
                System.out.println("The correct answer was: " + map.get(asked.get(i)).get("correct"));
                System.out.println();
                }
        }

        if(score>=5)
            System.out.println("Great Job!  You're score was: " + score);
        else
            System.out.println("Those were some tough ones!  You're score was: " + score);

        System.out.println();
        System.out.println("Thanks for playing!");
    }
}
