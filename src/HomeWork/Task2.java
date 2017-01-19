package HomeWork;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 19.01.2017.
 */
public class Task2 {
    public static void main(String[] args) {
        Map<String, String> params = new HashMap<>();
        params.put("1th", "Rings");
        params.put("2nd", "Dark");
        params.put("3rd", "throne");
        fileContentReplacer(params);

    }

    public static File fileContentReplacer(Map<String, String> params) {
        String content = Task1.replacer(params);
        BufferedReader br = null;
        BufferedWriter bw = null;
        File endingFile = new File("D:\\practice\\Module11\\src\\testModule2.txt");
        try {

            bw = new BufferedWriter(new FileWriter(endingFile));
            bw.write(content);
            System.out.println("Done!");
        } catch (IOException e) {
            System.out.print(e.getClass().getSimpleName() + ": " + e.getMessage());
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (bw != null)
                    bw.close();

            } catch (IOException e) {
                System.out.print(e.getClass().getSimpleName() + ": " + e.getMessage());
            }
        }
        return endingFile;
    }
}
