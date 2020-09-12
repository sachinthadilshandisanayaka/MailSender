import ErrorsCheckRepository.FileStringRepository;
import ErrorsCheckRepository.StringRepository;
import authorization.Authorization;
import authorization.EmailAuthorization;
import emailManager.EmailHub;
import input.CommandLineInput;
import input.Input;
import emailRepository.EmailRepository;
import emailRepository.MysqlEmailRepository;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static String errors;
    public static void main(String[] args) {
        String errorMessage = "Can not access the internet\n" +
                "Email is incorect\n" +
                "User Name is incorrect";
//        Input input = new CommandLineInput();
//        String filePath = input.readOperator();
//        System.out.println(filePath);
        StringRepository stringRepository = new FileStringRepository();
        try {
            errors = stringRepository.FileRead("hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(errors);

//        EmailRepository emailRepository = new MysqlEmailRepository();
//        ArrayList<String> emails = emailRepository.ReadOperation();
//
//        Authorization authorization = new EmailAuthorization();
//        ArrayList<String> newEmails =  authorization.Validation(emails);
//
//        System.out.println(newEmails);
//
//        EmailHub emailHub = new EmailHub();
//        emailHub.EmailSendRepository(newEmails, errorMessage);
    }
}
