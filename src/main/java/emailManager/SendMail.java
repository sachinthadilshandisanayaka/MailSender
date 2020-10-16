package emailManager;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import emailManager.emailComponent.MailGun;
import emailManager.emailComponent.MainGunVarification;
import emailManager.emailComponent.SenderEmail;

public class SendMail {
    public JsonNode sendSimpleMessage(String email, String erroMessage, String subject) throws UnirestException {
        String url = null;
        String password = null;
        SenderEmail sendMail = new MailGun();
        MainGunVarification mainGunVarification = new MailGun();
        HttpResponse<JsonNode> request = Unirest.post( mainGunVarification.getURL() + mainGunVarification.getKey() + "/messages")
                .basicAuth("api", mainGunVarification.getPassword())
                .field("from", sendMail.get())
                .field("to", email)
                .field("subject", subject)
                .field("text", erroMessage)
                .asJson();

        return request.getBody();
    }

}
