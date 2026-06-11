package com.xworkz.creatbankaccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreactAccount {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver load sucessfully");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //connection
        String sqlQuery="INSERT INTO account_info VALUES (1,'Prateek Deshbhandari', 1234567890, 'Savings', 5000.00, 9876543210, 'prateek@gmail.com', 'Mysore')";
        Connection connection=null;
        Statement statement=null;
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_db","root","Prateek@#1");
            statement=connection.createStatement();
            statement.execute(sqlQuery);
            System.out.println("data is succesfuly enterd....");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(connection !=null){

                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                if (statement!=null){
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
