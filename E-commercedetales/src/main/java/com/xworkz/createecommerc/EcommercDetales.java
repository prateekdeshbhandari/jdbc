package com.xworkz.createecommerc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EcommercDetales {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver load sucessfully");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }



        //connection
        String sqlQuery ="INSERT INTO  users_info VALUES (1, 'PRATEEK','prateek@gmail.com', 'prateek133', 8762540280),(2, 'prajwal','prajwal@gmail.com', 'prajwal133', 9867540280),(3, 'praveen','praveen@gmail.com', 'praveen133', 9876540280)";
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
