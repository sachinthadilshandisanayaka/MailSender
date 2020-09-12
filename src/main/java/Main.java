import repository.FileStringRepository;
import repository.StringRepository;
import timeStampRepository.FileTimeStampRepository;
import timeStampRepository.TimeStampReposiroty;

import java.io.IOException;

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

        TimeStampReposiroty timeStampReposiroty = new FileTimeStampRepository();
        String timeStamp = timeStampReposiroty.GetTimeStamp();
        System.out.println(timeStamp);

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
