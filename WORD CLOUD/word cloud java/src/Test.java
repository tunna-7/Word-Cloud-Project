import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map.*;
import java.util.*;





public class Test {

    final static String outputFilePath = "C:/Users/ayuwun6y/Documents/WORD CLOUD/MyText.txt";

    public static void main(String[] args) throws IOException {
        String directory = "C:/MGCNoScan/repos/iesd-23";
        List<String> classes = getClasses(directory);

        Map<String,ArrayList<String>> mainMap = new HashMap<String,ArrayList<String>>();
        for(String myString: classes){
            String[] myKey = myString.split(",");
            if(mainMap.containsKey(myKey[0])){
                ArrayList<String> tempArr = new ArrayList<String>();
                tempArr = mainMap.get(myKey[0]);
                tempArr.add(myKey[1]);
                mainMap.replace(myKey[0], tempArr);
            }else{
                ArrayList<String> Arr = new ArrayList<String>();
                Arr.add(myKey[1]);
                mainMap.put(myKey[0], Arr);
            }
        }

        System.out.println("Writing to the file!!!");
        //*****Writing to a file*****
        File file = new File(outputFilePath);
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file));
            for (Entry<String, ArrayList<String>> entry : mainMap.entrySet()) {
                bf.write(entry.getKey() + ":" + entry.getValue());
                bf.newLine();
            }
            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bf.close();
            }
            catch (Exception e) {
            }
        }

        System.out.println("Check Text File!!!");

    }

    public static List<String> getClasses(String directory) throws IOException {
        System.out.println("Reading Files....Please Wait");
        List<String> classes = new ArrayList<>();
        File dir = new File(directory);
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                classes.addAll(getClasses(file.getAbsolutePath()));
            } else if (file.getName().endsWith(".java")) {
                // System.out.println(file.getAbsolutePath());
                String content = new String(Files.readAllBytes(file.toPath()));
                Pattern pattern = Pattern.compile("class\\s+(\\w+)");
                Matcher matcher = pattern.matcher(content);
                while (matcher.find()) {
                    String classN = matcher.group(1); //Class Name
                    String classL = file.getAbsolutePath(); //Class Location
                    classes.add(classN + ","+classL);
                }
            }
        }
        return classes;
    }

}