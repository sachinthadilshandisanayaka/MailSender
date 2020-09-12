import input.CommandLineInput;
import input.Input;
import operation.FilterOperation;
import operation.Operation;
import repository.FileStringRepository;
import repository.StringRepository;
import timeStampRepository.FileTimeStampRepository;
import timeStampRepository.TimeStampReposiroty;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> readedData = null;
        String timeStamp = null;
//        String errorMessage2 = "Can not access the internet\n" +
//                "Email is incorect\n" +
//                "User Name is incorrect";
//        Input input = new CommandLineInput();
//        String filePath = input.readOperator();
//        System.out.println(filePath);
        StringRepository stringRepository = new FileStringRepository();
        try {
            readedData = stringRepository.FileRead("hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(readedData);

//        TimeStampReposiroty timeStampReposiroty = new FileTimeStampRepository();
//         timeStamp = timeStampReposiroty.GetTimeStamp();
//        System.out.println(timeStamp);

        Operation operation = new FilterOperation();
        String errorMessage = operation.GetErrors( readedData, "2020-09-06T17:24:09Z");

//        TimeStampReposiroty timeStampReposiroty1 = new FileTimeStampRepository();
//        timeStampReposiroty1.SetTimeStamp("2020-09-99T00:00:00Z");

//        EmailRepository emailRepository = new MysqlEmailRepository();
//        ArrayList<String> emails = emailRepository.ReadOperation();
//
//        Authorization authorization = new EmailAuthorization();
//        ArrayList<String> newEmails =  authorization.Validation(emails);
//
//        System.out.println(newEmails);
//
//        EmailHub emailHub = new EmailHub();
//        emailHub.EmailSendRepository(newEmails, errorMessage2);
    }
}
