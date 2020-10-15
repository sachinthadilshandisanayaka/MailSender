import emailManager.EmailMagange;
import inputValidation.FileExistsCheck;
import inputValidation.PathExistsCheck;
import ui.CommandLineUI;
import ui.Ui;
import authorization.Authorization;
import authorization.EmailAuthorization;
import emailManager.MainGunEmail;
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


public class Main {

    public static void main(String[] args) {

        Input input = new CommandLineInput();
        PathExistsCheck pathExistsCheck = new FileExistsCheck();
        StringRepository stringRepository = new FileStringRepository();
        TimeStampReposiroty timeStampReposiroty = new FileTimeStampRepository();
        Operation operation = new FilterOperation();
        EmailRepository emailRepository = new MysqlEmailRepository();
        Authorization authorization = new EmailAuthorization();
        EmailMagange emailMagange = new MainGunEmail();
        Ui ui = new CommandLineUI();
        MailSendApp mailSendApp = new MailSendApp(input, pathExistsCheck, stringRepository,  timeStampReposiroty, operation,
                emailRepository, authorization, emailMagange, ui);
        mailSendApp.Execute();

    }
}
