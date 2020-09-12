package emailManager;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class SendMail {
    public JsonNode sendSimpleMessage(String email, String erroMessage) throws UnirestException {
        String url = null;
        String password = null;

        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + url + "/messages")
                .basicAuth("api", password)
                .field("from", "sachidisanayaka98@gmail.com")
                .field("to", email)
                .field("subject", "ERROR")
                .field("text", erroMessage)
                .asJson();

        return request.getBody();
    }

}
