import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class FileExtensions {
    public static void main(String[] args) {
        // Change the path to the folder you want to scan
        String folderPath = "/path/to/folder";

        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        // Use a set to store the unique file extensions
        Set<String> extensions = new HashSet<>();

        for (File file : files) {
            String fileName = file.getName();
            int dotIndex = fileName.lastIndexOf('.');
            if (dotIndex > 0) {
                // Get the extension by substringing the file name after the dot
                String extension = fileName.substring(dotIndex + 1);
                extensions.add(extension);
            }
        }

        // Print the extensions
        for (String extension : extensions) {
            System.out.println(extension);
        }
    }
}
