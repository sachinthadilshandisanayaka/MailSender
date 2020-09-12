package operation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class FilterOperation implements Operation{
    public Date date;
    public String GetErrors ( ArrayList<String> errors, String time ) {

        String errorMessage = "";
        String pattern = "yyyy-MM-dd'T'HH:mm:ssZ";
        String sDate6 = "31-Dec-1998 23:37:50";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.ENGLISH);

        try {
            Date date = simpleDateFormat.parse(sDate6);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        for ( String error: errors ) {
//            String[] Slited_error = error.split(" ");
//            if(Slited_error[1].equals("ERROR") ) {
//                errorMessage += Slited_error[2] + "\n";
//            }
//        }

        return errorMessage;
    }
}
