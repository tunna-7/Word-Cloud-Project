import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassFinder {
    public static void main(String[] args) throws Exception {
        // Change the path to the folder you want to scan
        String folderPath = "/path/to/folder";

        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        // Use a set to store the unique class names
        Set<String> classNames = new HashSet<>();

        // Use a regular expression to find class declarations
        Pattern pattern = Pattern.compile("(public|private|protected)\\s+class\\s+(\\w+)");

        for (File file : files) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    classNames.add(matcher.group(2));
                }
            }

            reader.close();
        }

        // Print the class names
        for (String className : classNames) {
            System.out.println(className);
        }
    }
}

/*
It uses the java.io.File class to represent a file or directory in the file system,
and the listFiles() method to get an array of all the files in the specified folder.

It then loops through the array of files, reads each file line by line,
and uses a regular expression to find class declarations. 
It stores the class names in a java.util.Set to eliminate duplicates, 
and finally loops through the set of class names and prints them out.
*/
