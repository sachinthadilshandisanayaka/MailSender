package timeStampRepository;

import java.io.*;
import java.util.*;


public class FileTimeStampRepository implements TimeStampReposiroty{

    FileInputStream fileInputStream;
    InputStreamReader inputStreamReader;
    BufferedReader bufferedReader;

    public String GetTimeStamp() {

        String time = "";
        File file = new File("C:\\Users\\sachi dissanayake\\Desktop\\Folder\\timeStamp.txt");

        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        inputStreamReader = new InputStreamReader(fileInputStream);
        bufferedReader = new BufferedReader(inputStreamReader);


        try {
            time = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileInputStream.close();
            inputStreamReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return time;
    }
    public void SetTimeStamp(String time) {
        FileWriter fileWriter = null;
        File file = new File("C:\\Users\\sachi dissanayake\\Desktop\\Folder\\timeStamp.txt");
        try {
            fileWriter = new FileWriter(file, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.write(time);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
