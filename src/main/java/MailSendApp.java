import authorization.Authorization;
import emailManager.EmailMagange;
import emailManager.MainGunEmail;
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
    private final EmailRepository emailRepository;
    private final Authorization authorization;
    private final EmailMagange emailMagange;
    private final Ui ui;

    public MailSendApp(Input input, StringRepository stringRepository, TimeStampReposiroty timeStampReposiroty,
                       Operation operation, EmailRepository emailRepository, Authorization authorization, EmailMagange emailMagange,
                       Ui ui) {
        this.input = input;
        this.stringRepository = stringRepository;
        this.timeStampReposiroty = timeStampReposiroty;
        this.operation = operation;
        this.emailRepository = emailRepository;
        this.authorization = authorization;
        this.emailMagange = emailMagange;
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

        if(readedData.size() == 0){
            ui.printData("LOG file is EMPTY");
            return;
        }

        if (readedData == null) {
            ui.printData("LOG file is EMPTY");
            return;
        }
        timeStamp = timeStampReposiroty.GetTimeStamp();
//        System.out.println(timeStamp);
        errorMessage = operation.GetErrors( readedData, timeStamp);

        if (errorMessage == null) {
            ui.printData("No ERRORS in file");
            return;
        }
        LastTimeStamp = operation.getLastTimeStamp( readedData );
        if(LastTimeStamp == null) {
            ui.printData("ERROR occurs");
            return;
        }
        timeStampReposiroty.SetTimeStamp(LastTimeStamp);
        ArrayList<String> emails = emailRepository.ReadOperation();
        if(emails == null) {
            ui.printData("NO Emails in DataBase");
            return;
        }
        ArrayList<String> newEmails =  authorization.Validation(emails);
        if(newEmails == null) {
            ui.printData("NO Valid Emails in DataBase");
            return;
        }
        ArrayList<String> returnMessage = emailMagange.EmailSendRepository(newEmails, errorMessage);
        if (returnMessage == null) {
            ui.printData("Can not send emails, There is error in that read log file or something");
        } else {
            System.out.println(errorMessage);
            ui.printData("EMAILS send");
        }
    }
}

















