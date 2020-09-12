package input;

import java.util.*;

public class CommandLineInput implements Input{
    public String filePath = null;

    public String readOperator() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter File Path :");
        filePath = scanner.nextLine();

        return filePath;
    }
}
