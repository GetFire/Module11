package HomeWork;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by GetFire on 19.01.2017.
 */
public class Task1 {

    public static final File FILE = new File("D:\\practice\\Module11\\src\\testModule.txt");

    public static void main(String[] args) {
        Map<String, String> params = new HashMap<>();
        params.put("1th", "Rings");
        params.put("2nd", "Dark");
        params.put("3rd", "throne");

        System.out.println(Task1.replacer(params));
    }
    public static String replacer(Map<String, String> map) {
        BufferedReader br = null;
        StringBuilder replaced = new StringBuilder();
        String line;

        try {
            br = new BufferedReader(new FileReader(FILE));
            while ((line = br.readLine()) != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    line = line.replaceAll(entry.getKey(), entry.getValue());
                }
                replaced.append(line);
                replaced.append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName());
        }finally {
            try {
                if(br!=null)
                    br.close();
            }catch (IOException e){
                System.out.println(e.getClass().getSimpleName());
            }
        }
        return replaced.toString();
    }
}
