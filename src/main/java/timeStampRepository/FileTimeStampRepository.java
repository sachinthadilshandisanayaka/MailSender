package timeStampRepository;

import timeStampRepository.timeStamp.GetFilePath;
import timeStampRepository.timeStamp.GetTimeStampPath;

import java.io.*;
import java.util.*;


public class FileTimeStampRepository implements TimeStampReposiroty{

    FileInputStream fileInputStream;
    InputStreamReader inputStreamReader;
    BufferedReader bufferedReader;

    public String GetTimeStamp() {
        GetTimeStampPath getTimeStampPath = new GetFilePath();
        String time = "";

        File file = new File(getTimeStampPath.GetFilePath());
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
        GetTimeStampPath getTimeStampPath = new GetFilePath();

        if ( time != null ){
            FileWriter fileWriter = null;
            File file = new File(getTimeStampPath.GetFilePath());
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
        else {
            return;
        }
    }

}
