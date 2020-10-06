package operation.dateFormatter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateConvertMethod implements DateFomate{
    public Date Convert(String date) {
        return Date.from(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
            .parse(date.replaceFirst("Z", ".000+0000"), ZonedDateTime::from).toInstant());
    }
}
