package operation.TimeStamGetter;

import operation.splitFile.FileSplit;
import operation.splitFile.SplitSpace;

import java.util.ArrayList;

public class LastTimeStampGet implements  TimeStamGet{
    FileSplit fileSplit = new SplitSpace();
    public String[] getTimeStamp(ArrayList<String> data) {
        return fileSplit.getSplit(data.get(data.size()-1));
    }
}
