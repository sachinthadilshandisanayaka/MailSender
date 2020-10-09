package emailManager;

import java.util.ArrayList;

public interface EmailMagange {
    ArrayList<String> EmailSendRepository(ArrayList<String> emails, String errorMessage);
}
