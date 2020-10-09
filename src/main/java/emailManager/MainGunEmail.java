package emailManager;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import emailManager.emailType.ErrorEmailType;
import emailManager.emailType.GetEmailType;

import java.util.ArrayList;

public class MainGunEmail implements EmailMagange{
    public ArrayList<String> EmailSendRepository(ArrayList<String> emails, String errorMessage) {
        GetEmailType getEmailType = new ErrorEmailType();
        if ( errorMessage != null ) {
            for (String email: emails ) {
                try {
                    SendMail mailSend = new SendMail();
                    JsonNode jsonNode = mailSend.sendSimpleMessage(email, errorMessage, getEmailType.Get());
                    System.out.println(jsonNode.toString());
                } catch (UnirestException e) {
                    e.printStackTrace();
                }
            }
            return emails;
        }
        return null;
    }

}
