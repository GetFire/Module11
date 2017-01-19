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


// По идее нужно в качестве параметра передать еще и файл, который мы будем менять.
// В данном случае исходный текст лежит в файле testModule.txt

    public static File fileContentReplacer(Map<String, String> params) {
        StringBuilder content = new StringBuilder();
        BufferedReader br = null;
        BufferedWriter bw = null;
        File endingFile = new File("D:\\practice\\Module11\\src\\testModule2.txt");
        String line;
        try {
            br = new BufferedReader(new FileReader(endingFile));
            while ((line = br.readLine()) != null) {
                for (Map.Entry<String, String> entry : params.entrySet())
                    line = line.replaceAll(entry.getKey(), entry.getValue());
                content.append(line);
                content.append(System.lineSeparator());
            }

            bw = new BufferedWriter(new FileWriter(endingFile));
            bw.write(content.toString());
            System.out.println("Done!");
        } catch (IOException e) {
            System.out.print(e.getClass().getSimpleName() + ": " + e.getMessage());
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (br != null)
                    br.close();

            } catch (IOException e) {
                System.out.print(e.getClass().getSimpleName() + ": " + e.getMessage());
            }
        }
        return endingFile;
    }
}
