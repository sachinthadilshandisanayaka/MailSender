package emailManager;

import emailManager.emailType.ErrorEmailType;
import emailManager.emailType.GetEmailType;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class LocalEmailSender implements EmailMagange {

    public ArrayList<String> EmailSendRepository(ArrayList<String> emails, String errorMessage) {
        String from = "web@gmail.com";
        String host = "localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        GetEmailType type = new ErrorEmailType();

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            for(String email : emails) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                message.setSubject(type.Get());
                message.setText(errorMessage);
                Transport.send(message);
            }
            return emails;
        } catch (MessagingException mex) {
            return null;
        }
    }
}
