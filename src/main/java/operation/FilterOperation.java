package operation;

import operation.TimeStamGetter.LastTimeStampGet;
import operation.TimeStamGetter.TimeStamGet;
import operation.dateFormatter.DateConvertMethod;
import operation.dateFormatter.DateFomate;
import operation.readedFileFilter.FileFilter;
import operation.readedFileFilter.GetFileLastTimeStam;
import operation.splitFile.FileSplit;
import operation.splitFile.SplitIntoThree;

import java.util.ArrayList;
import java.util.Date;

public class FilterOperation implements Operation{

    public String GetErrors ( ArrayList<String> readedDate, String time ) {
        Date date = null;
        String errorMessage = "";
        DateFomate dateFomate = new DateConvertMethod();
        FileFilter fileFilter = new GetFileLastTimeStam();
        FileSplit fileSplit  = new SplitIntoThree();

        if( !fileFilter.GetLastTimeStamp(readedDate).equals(time)) {
            if ( readedDate.size() > 0) {
                if ( time != null) {
                    date =  dateFomate.Convert(time);
                }
                for ( String fileData: readedDate ) {
                    String[] fileDate = fileData.split(" ");
                    Date temporyDate = dateFomate.Convert(fileDate[0]);
                    if ( date != null ) {
                        long diff = date.getTime() - temporyDate.getTime();
                        if ( diff < 0 ) {
                            if(fileDate[1].equals("ERROR") ) {
//                                String[] split_error_message = fileData.split(" ", 3);
                                String[] split_error_message = fileSplit.getSplit(fileData);
                                errorMessage += split_error_message[2] + "\n";
                            }
                        }
                    } else {
                        if(fileDate[1].equals("ERROR") ) {
//                            String[] split_error_message = fileData.split(" ", 3);
                            String[] split_error_message = fileSplit.getSplit(fileData);
                            errorMessage += split_error_message[2] + "\n";
                        }
                    }
                }
                if( errorMessage != null ) {
                    return errorMessage;
                }
            }
        }
        return null;
    }
    public String getLastTimeStamp (ArrayList<String> readedData ) {
        TimeStamGet timeStamGet = new LastTimeStampGet();
        if ( readedData.size() > 0) {
            String[] date = timeStamGet.getTimeStamp(readedData);
            return date[0];
        }
       else {
           return null;
        }
    }
}
