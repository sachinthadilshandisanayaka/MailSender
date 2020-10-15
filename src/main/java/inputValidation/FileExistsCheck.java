package inputValidation;
import java.io.*;

public class FileExistsCheck implements PathExistsCheck{
    public Boolean Check(String path) {
        File file = new File(path);
        if(file.exists()) {
            return true;
        } else
        {
            return false;
        }
    }
}
