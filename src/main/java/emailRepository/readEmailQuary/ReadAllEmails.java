package emailRepository.readEmailQuary;

public class ReadAllEmails implements ReadEmails{
    private String quary;
    public String Quary() {
        quary = "SELECT useremail FROM email";
        return quary;
    }
}
