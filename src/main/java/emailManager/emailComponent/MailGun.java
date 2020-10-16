package emailManager.emailComponent;

public class MailGun implements SenderEmail, MainGunVarification{
    public String get() {
        return "sachidisanayaka98@gmail.com";
    }
    public String getPassword() {
        return "1f39a178b73a57ce04dee76361879a98-0f472795-e19a09a9";
    }
    public String getKey() {
        return "sandbox1578a10878f343abafdf04c79479b78b.mailgun.org";
    }
    public String getURL() {
        return "https://api.mailgun.net/v3/";
    }
}
