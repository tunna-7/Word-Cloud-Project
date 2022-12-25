import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.nio.file.Files;

public class ClassFinder {

    public static void main(String[] args) throws IOException {
        String directory = "C:/Users/wayus/OneDrive/Desktop/Ayush Wunnava/Timepass/word cloud/main";
        List<String> classes = getClasses(directory);
        for (String className : classes) {
            System.out.println(className);
        }
    }

    public static List<String> getClasses(String directory) throws IOException {
        List<String> classes = new ArrayList<>();
        File dir = new File(directory);
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                classes.addAll(getClasses(file.getAbsolutePath()));
            } else if (file.getName().endsWith(".java")) {
                String content = new String(Files.readAllBytes(file.toPath()));
                Pattern pattern = Pattern.compile("class\\s+(\\w+)");
                Matcher matcher = pattern.matcher(content);
                while (matcher.find()) {
                    classes.add(matcher.group(1));
                }
            }
        }
        return classes;
    }

}
