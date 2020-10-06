package operation;

import operation.dateFormatter.DateConvertMethod;
import operation.dateFormatter.DateFomate;
import operation.readedFileFilter.FileFilter;
import operation.readedFileFilter.GetFileLastTimeStam;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class FilterOperation implements Operation{

    public String GetErrors ( ArrayList<String> readedDate, String time ) {
        Date date = null;
        String errorMessage = "";
        DateFomate dateFomate = new DateConvertMethod();
//        String sDate6 = "2020-09-06T17:29:20Z";
//        Date date = Date.from(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(sDate6.replaceFirst("Z", ".000+0000"), ZonedDateTime::from).toInstant());
//        String[] data = readedDate.get(readedDate.size()-1).split(" ");

        FileFilter fileFilter = new GetFileLastTimeStam();

        if( !fileFilter.GetLastTimeStamp(readedDate).equals(time)) {

            if ( readedDate.size() > 0) {

                if ( time != null) {
                    //date = Date.from(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(time.replaceFirst("Z", ".000+0000"), ZonedDateTime::from).toInstant());

                    date =  dateFomate.Convert(time);
                }
//        System.out.println(date);

                for ( String fileData: readedDate ) {

                    String[] fileDate = fileData.split(" ");

//                    String parseString = fileDate[0];
//                    Date temporyDate = Date.from(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(parseString.replaceFirst("Z", ".000+0000"), ZonedDateTime::from).toInstant());
                    Date temporyDate = dateFomate.Convert(fileDate[0]);

                    if ( date != null ) {
                        long diff = date.getTime() - temporyDate.getTime();
                        if ( diff < 0 ) {
                            if(fileDate[1].equals("ERROR") ) {

                                String[] split_error_message = fileData.split(" ", 3);
                                errorMessage += split_error_message[2] + "\n";
                            }
                        }
                    } else {
                        if(fileDate[1].equals("ERROR") ) {

                            String[] split_error_message = fileData.split(" ", 3);
                            errorMessage += split_error_message[2] + "\n";
                        }
                    }

                }
                if( errorMessage != null ) {
                    return errorMessage;
                }
//                System.out.println("No ERRORS found");
            }  //                System.out.println("LOG File is EMPTY");

        }
        //            System.out.println("Log File is not Updated");

        return null;
    }
    public String getLastTimeStamp (ArrayList<String> readedData ) {
        if ( readedData.size() > 0) {
            String[] date = readedData.get(readedData.size()-1).split(" ");
            return date[0];
        }
       else {
           return null;
        }
    }
}
