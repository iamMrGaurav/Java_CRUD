package org.example;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Authenticate {
    public static void handleLogin(Scanner scanner){
        System.out.println("Enter username");
        String userName = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        isLoginValid(userName,password);
    }

    public static void isLoginValid(String userName,String password){
        try{
            Connection connection = DatabaseHelper.getConnection();
            String query = "SELECT * FROM user WHERE user_name = \""+userName+"\" AND password = \""+password+"\";";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                Main.user = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4));
            }
            connection.close();

        }catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

}
