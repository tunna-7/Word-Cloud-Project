import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassFinder {
    public static void main(String[] args) throws Exception {
        // Change the path to the file you want to scan
        String filePath = "/path/to/file.java";

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        // Use a regular expression to find class declarations
        Pattern pattern = Pattern.compile("(public|private|protected)\\s+class\\s+(\\w+)");

        while ((line = reader.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                System.out.println(matcher.group(2));
            }
        }

        reader.close();
    }
}
