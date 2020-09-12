import authorization.Authorization;
import emailManager.EmailHub;
import emailRepository.EmailRepository;
import input.Input;
import operation.Operation;
import repository.StringRepository;
import timeStampRepository.TimeStampReposiroty;
import ui.Ui;

import java.io.IOException;
import java.util.ArrayList;

public class MailSendApp {
    private final Input input;
    private final StringRepository stringRepository;
    private final TimeStampReposiroty timeStampReposiroty;
    private final Operation operation;
    private final Operation operation1;
    private final TimeStampReposiroty timeStampReposiroty1;
    private final EmailRepository emailRepository;
    private final Authorization authorization;
    private final EmailHub emailHub;
    private final Ui ui;

    public MailSendApp(Input input, StringRepository stringRepository, TimeStampReposiroty timeStampReposiroty,
                       Operation operation, Operation operation1, TimeStampReposiroty timeStampReposiroty1,
                       EmailRepository emailRepository, Authorization authorization, EmailHub emailHub, Ui ui) {
        this.input = input;
        this.stringRepository = stringRepository;
        this.timeStampReposiroty = timeStampReposiroty;
        this.operation = operation;
        this.operation1 = operation1;
        this.timeStampReposiroty1 = timeStampReposiroty1;
        this.emailRepository = emailRepository;
        this.authorization = authorization;
        this.emailHub = emailHub;
        this.ui = ui;
    }
    public void Execute() {
        ArrayList<String> readedData = null;
        String timeStamp = null;
        String errorMessage = null;
        String LastTimeStamp = null;

        String filePath = input.readOperator();
        try {
            readedData = stringRepository.FileRead(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (readedData.equals(null)) {
            ui.printData("LOG file is EMPTY");
            return;
        }
        timeStamp = timeStampReposiroty.GetTimeStamp();
        System.out.println(timeStamp);
        errorMessage = operation.GetErrors( readedData, timeStamp);

        if (errorMessage.equals(null)) {
            ui.printData("No ERRORS in file");
            return;
        }
        LastTimeStamp = operation1.getLastTimeStamp( readedData );
        if(LastTimeStamp.equals(null)) {
            ui.printData("ERROR occurs");
            return;
        }
        timeStampReposiroty1.SetTimeStamp(LastTimeStamp);
        ArrayList<String> emails = emailRepository.ReadOperation();
        if(emails.equals(null)) {
            ui.printData("NO Emails in DataBase");
            return;
        }
        ArrayList<String> newEmails =  authorization.Validation(emails);
        if(newEmails.equals(null)) {
            ui.printData("NO Valid Emails in DataBase");
            return;
        }
        ArrayList<String> returnMessage = emailHub.EmailSendRepository(newEmails, errorMessage);
        if (readedData.equals(null)) {
            ui.printData("Can not send emails, There is error in that read log file or something");
        } else {
            ui.printData("EMAILS send");
        }
    }
}

















