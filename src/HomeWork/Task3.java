package HomeWork;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 19.01.2017.
 */
public class Task3 {
    public static void main(String[] args) {
        Map<String, String> params = new HashMap<>();
        params.put("1th", "Rings");
        params.put("2nd", "Dark");
        params.put("3rd", "throne");

        File file = fileContentMerger(params);
    }

    public static File fileContentMerger(Map<String, String> params) {
        File file = new File("D:\\practice\\Module11\\src\\testModule3.txt");
        StringBuilder content = new StringBuilder();
        String readLine;
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(file));
            bw = new BufferedWriter(new FileWriter(file, true));
            while ((readLine = br.readLine()) != null) {
                for (Map.Entry<String, String> entry : params.entrySet())
                    readLine = readLine.replaceAll(entry.getKey(), entry.getValue());
                content.append(readLine);
                content.append(System.lineSeparator());
            }
            bw.write(System.lineSeparator());
            bw.write("\n");
            bw.write(content.toString());
            System.out.println("Done!");
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
                if (bw != null) bw.close();
            } catch (IOException e) {
                System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
            }
        }
        return file;
    }
}
