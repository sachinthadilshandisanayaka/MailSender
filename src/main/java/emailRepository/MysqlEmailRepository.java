package emailRepository;

import dataBaseConnection.GetConnection;
import dataBaseConnection.MysqlDataBaseConnection;
import emailRepository.readEmailQuary.ReadAllEmails;
import emailRepository.readEmailQuary.ReadEmails;

import java.sql.*;
import java.util.ArrayList;

public class MysqlEmailRepository implements EmailRepository{

    ArrayList<String> userData = new ArrayList<String>();

    public ArrayList<String> ReadOperation() {
        GetConnection getConnection = new MysqlDataBaseConnection();

        try {
            Statement st = getConnection.EmailRepository().createStatement();
            ReadEmails readEmails = new ReadAllEmails();
            ResultSet rs = st.executeQuery(readEmails.Quary());
            while (rs.next()) {
                userData.add(rs.getString(1));
            }
            return userData;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
