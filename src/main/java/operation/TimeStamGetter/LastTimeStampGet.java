package operation.LastTimeStamGetter;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.util.ArrayList;

public class LastTimeStampGet implements  TimeStamGet{
    public String[] getTimeStamp(ArrayList<String> data) {
        return data.get(data.size()-1).split(" ");
    }
}
