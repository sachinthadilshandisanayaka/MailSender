package emailManager;

import emailManager.emailComponent.Official;
import emailManager.emailComponent.SenderEmail;
import emailManager.emailType.ErrorEmailType;
import emailManager.emailType.GetEmailType;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class LocalEmailSender implements EmailMagange {

    public ArrayList<String> EmailSendRepository(ArrayList<String> emails, String errorMessage) {
        String host = "localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        GetEmailType type = new ErrorEmailType();
        SenderEmail from = new Official();

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from.get()));
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
