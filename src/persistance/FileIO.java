package persistance;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {

    public static boolean create(String path)
    {
        File file = new File(path);
        try {
            return file.createNewFile();
        }catch (IOException e) {
            return false;
        }
    }

    public static boolean create(String path, String content)
    {
        File file = new File(path);
        try {
            boolean isCreated = file.createNewFile();
            return write(path, content) ?  isCreated : isCreated;
        }catch (IOException e) {
            return false;
        }
    }

    private static String read(String path)
    {
        StringBuilder stringBuilder = new StringBuilder();
        try
        {
            Scanner scanner = new Scanner(new File(path));

            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
            }
        }
        catch (IOException e)
        {
            return null;
        }

        return stringBuilder.toString();
    }

    public static boolean update(String path, String content)
    {
        List<String> stringList = new ArrayList<String>();
        String fileContent = read(path);
        stringList.add(content);

        return write(path, stringList.toString());
    }

    public static boolean delete(String path)
    {
         File file = new File(path);
         return file.delete();
    }

    public static boolean write(String fileName, String fileContent)
    {
        try
        {
            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(fileContent);
            fileWriter.flush();

            return true;
        }
        catch (IOException e)
        {
            return false;
        }
    }

}
