package HomeWork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by GetFire on 19.01.2017.
 */
public class task4_v1 {
    public static void main(String[] args) {
        String word = "Ring";
        checkWord(word);
    }

    public static int checkWord(String word) {
        int count = 0;
        BufferedReader br = null;
        StringBuilder content = new StringBuilder();
        String line;

        try {
            br = new BufferedReader(new FileReader(Task1.FILE));
            while ((line = br.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
            count = content.toString().split(word).length - 1;
            System.out.println("Done!");
            System.out.println("Result: " + count);
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
            }
        }


        return count;
    }

}
