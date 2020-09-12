import authorization.Authorization;
import authorization.EmailAuthorization;
import emailManager.EmailHub;
import emailRepository.EmailRepository;
import emailRepository.MysqlEmailRepository;
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

        Input input = new CommandLineInput();
        String filePath = input.readOperator();
//        System.out.println(filePath);
        StringRepository stringRepository = new FileStringRepository();
        try {
            readedData = stringRepository.FileRead(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(readedData);

        TimeStampReposiroty timeStampReposiroty = new FileTimeStampRepository();
        timeStamp = timeStampReposiroty.GetTimeStamp();
//        System.out.println(timeStamp);

        Operation operation = new FilterOperation();
        String errorMessage = operation.GetErrors( readedData, timeStamp);
//        System.out.println(errorMessage);

        Operation operation1 = new FilterOperation();
        String LastTimeStamp = operation1.getLastTimeStamp( readedData );
//        System.out.println(LastTimeStamp);

        TimeStampReposiroty timeStampReposiroty1 = new FileTimeStampRepository();
        timeStampReposiroty1.SetTimeStamp(LastTimeStamp);

        EmailRepository emailRepository = new MysqlEmailRepository();
        ArrayList<String> emails = emailRepository.ReadOperation();

        Authorization authorization = new EmailAuthorization();
        ArrayList<String> newEmails =  authorization.Validation(emails);

//        System.out.println(newEmails);
//        System.out.println(errorMessage);
        EmailHub emailHub = new EmailHub();
        emailHub.EmailSendRepository(newEmails, errorMessage);

    }
}
