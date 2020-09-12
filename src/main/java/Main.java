import authorization.Authorization;
import authorization.EmailAuthorization;
import emailManager.EmailHub;
import emailManager.SendMail;
import input.CommandLineInput;
import input.Input;
import repository.EmailRepository;
import repository.MysqlEmailRepository;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String errorMessage = "Can not access the internet\n" +
                "Email is incorect\n" +
                "User Name is incorrect";
        Input input = new CommandLineInput();
        String filePath = input.readOperator();

        

        EmailRepository emailRepository = new MysqlEmailRepository();
        ArrayList<String> emails = emailRepository.ReadOperation();

        Authorization authorization = new EmailAuthorization();
        ArrayList<String> newEmails =  authorization.Validation(emails);

        System.out.println(newEmails);

        EmailHub emailHub = new EmailHub();
        emailHub.EmailSendRepository(newEmails, errorMessage);
    }
}
