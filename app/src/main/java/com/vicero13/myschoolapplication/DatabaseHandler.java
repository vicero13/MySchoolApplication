package com.vicero13.myschoolapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql//" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;

    }

//    public void signUpUser(String firstname, String lastname, String username, String password, String email){
//        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME
//                + "," + Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + "," + Const.USERS_EMAIL + ")"
//                + "VALUES(?,?,?,?,?)";

    public void signUpUser(String email, String password){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_EMAIL + "," + Const.USERS_PASSWORD + ")"
                + "VALUES(?,?)";


        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
