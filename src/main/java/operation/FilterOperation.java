package operation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class FilterOperation implements Operation{
//    public Date date;
    public String GetErrors ( ArrayList<String> readedDate, String time ) {

        String errorMessage = "";
        String pattern = "yyyy-MM-dd'T'HH:mm:ssZ";
//        String sDate6 = "2020-09-06T17:29:20Z";

//        Date date = Date.from(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(sDate6.replaceFirst("Z", ".000+0000"), ZonedDateTime::from).toInstant());
        Date date = Date.from(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(time.replaceFirst("Z", ".000+0000"), ZonedDateTime::from).toInstant());
//        System.out.println(date);

        for ( String fileData: readedDate ) {

            String[] fileDate = fileData.split(" ");
            String parseString = fileDate[0];

            Date temporyDate = Date.from(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(parseString.replaceFirst("Z", ".000+0000"), ZonedDateTime::from).toInstant());

            long diff = date.getTime() - temporyDate.getTime();
            if ( diff < 0 ) {
                if(fileDate[1].equals("ERROR") ) {

                    String[] split_error_message = fileData.split(" ", 3);
                    errorMessage += split_error_message[2] + "\n";
                }
            }
        }



        System.out.println(errorMessage);
        return errorMessage;
    }
}
