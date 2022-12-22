import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClassNamePrinter {

    public static void main(String[] args) {
        // Set the root directory
        String rootDir = "/path/to/root/directory";

        // Get a list of all the files in the root directory
        List<File> files = getFiles(rootDir);

        // Print out the class names
        for (File file : files) {
            if (file.getName().endsWith(".class")) {
                String className = file.getName().replace(".class", "");
                System.out.println(className);
            }
        }
    }

    public static List<File> getFiles(String rootDir) {
        List<File> files = new ArrayList<>();
        getFilesRecursively(rootDir, files);
        return files;
    }

    public static void getFilesRecursively(String dir, List<File> files) {
        File root = new File(dir);
        File[] list = root.listFiles();

        if (list == null) return;

        for (File f : list) {
            if (f.isDirectory()) {
                getFilesRecursively(f.getAbsolutePath(), files);
            } else {
                files.add(f);
            }
        }
    }
}

/*
This code uses a recursive function to search through the specified root directory and all of its subdirectories for files. 
If a file is found, it is added to a list of files. The list of files is then iterated over and the class names are printed out. 
*/

/*
Note that this code will only work for class files that are located in the root directory or one of its subdirectories. 
It will not search for class files in jar files or other types of archives.
*/
