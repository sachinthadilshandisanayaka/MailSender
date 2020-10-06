package operation.readedFileFilter;

import java.util.ArrayList;

public class GetFileLastTimeStam implements  FileFilter{

    public String GetLastTimeStamp(ArrayList<String> data) {
        String[] result = data.get(data.size()-1).split(" ");
        return result[0];
    }
}
