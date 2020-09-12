package ErrorsCheckRepository;

import java.io.*;

public class FileStringRepository implements StringRepository{

    FileInputStream fileInputStream;
    InputStreamReader inputStreamReader;
    BufferedReader bufferedReader;
    String path2 = "C:\\Users\\sachi dissanayake\\Desktop\\Folder\\log.txt";

    public String FileRead(String path) throws IOException {
        String line;
        String errors = "";
        File file = new File(path2);

        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        inputStreamReader = new InputStreamReader(fileInputStream);
        bufferedReader = new BufferedReader(inputStreamReader);

        while ((line = bufferedReader.readLine())!= null){
            errors += line + "\n";
        }
        return errors;
    }
}
